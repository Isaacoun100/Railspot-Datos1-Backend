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

@RestController
public class WebHost {

    @GetMapping("/")
    public String login(){
        UserTree.saveUser();
        return UserTree.userTree.toString();
    }

    @GetMapping("/getUser/{userKey}")
    public JSONObject getUser(@PathVariable int userKey){
        try {
            NodeAVL<User> user = UserTree.searchUser(userKey);
            return UserTree.userToJSON(user);
        }
        catch (NullPointerException e){return UserTree.userToJSON(null);}
    }

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
