package com.itcr.datos.railspot.host;

import com.itcr.datos.railspot.dataStructures.GraphNode;
import com.itcr.datos.railspot.dataStructures.NodeAVL;
import com.itcr.datos.railspot.management.GraphRoutes;
import com.itcr.datos.railspot.management.UserTree;
import com.itcr.datos.railspot.objects.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class used for the implementation of the API methods
 */
@RestController
public class WebHost {
    /**
     * Function used for the login
     * @return returns User tree into string
     */
    @GetMapping("/")
    public String login(){
        return UserTree.userTree.toString();
    }

    /**
     * Function used for getting the user searched
     * @param userKey the key for the user
     * @return returns user into JSON
     */
    @GetMapping("/getUser/{userKey}")
    public JSONObject getUser(@PathVariable int userKey){
        try {
            NodeAVL<User> user = UserTree.searchUser(userKey);
            return UserTree.userToJSON(user);
        }
        catch (NullPointerException e){return UserTree.userToJSON(null);}
    }

    /**
     * Function used for adding a new edge
     * @param from the place where the edge starts
     * @param to the edge where the edge goes
     * @param cost the cost of the edge
     * @return returns the a true or false response
     */
    @GetMapping("/addEdge/{from}/{to}/{cost}")
    public JSONObject addEdge(@PathVariable String from, @PathVariable String to, @PathVariable int cost){
        JSONObject response = new JSONObject();
        try{
            GraphNode<String> fromNode = GraphRoutes.getGraph().search(from);
            if (fromNode != null){
                GraphNode<String> toNode = new GraphNode<>(to);
                fromNode.addEdge(fromNode, toNode, cost);
            }
            response.put("Response" , true);
        }catch(NullPointerException e){
            e.printStackTrace();
            response.put("Response" , false);
        }
        return response;
    }

    /**
     * Function for deleting edges
     * @param from the node where the edge starts
     * @param to the node where the edge geos
     * @return returns a true or false response
     */
    @GetMapping("/deleteEdge/{from}/{to}")
    public JSONObject deleteEdge(@PathVariable String from, @PathVariable String to){
        JSONObject response = new JSONObject();
        try{
            GraphNode<String> fromNode = GraphRoutes.getGraph().search(from);
            GraphNode<String> toNode =  GraphRoutes.getGraph().search(to);
            if(fromNode != null && toNode != null){
                GraphRoutes.getGraph().deleteEdge(from, to);
            }
            response.put("Response" , true);
        }catch(NullPointerException e){
            e.printStackTrace();
            response.put("Response" , false);
        }
        return response;
    }

}
