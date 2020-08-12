package com.itcr.datos.railspot.host;

import com.itcr.datos.railspot.management.UserTree;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHost {

    @GetMapping("/")
    public String login(){
        UserTree.saveUser();
        return UserTree.userTree.toString();
    }

}
