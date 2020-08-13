package com.itcr.datos.railspot.host;

import com.itcr.datos.railspot.dataStructures.NodeAVL;
import com.itcr.datos.railspot.management.UserTree;
import com.itcr.datos.railspot.objects.User;
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

}
