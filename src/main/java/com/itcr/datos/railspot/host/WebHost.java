package com.itcr.datos.railspot.host;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHost {

    @GetMapping("/")
    public String login(){
        return "Welcome to RailSpot";
    }

}
