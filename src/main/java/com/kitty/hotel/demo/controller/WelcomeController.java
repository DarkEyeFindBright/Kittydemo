package com.kitty.hotel.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping(path = "/")
    public String welcome(){
        return "index";
    }
    @GetMapping(path = "/login")
    public String toLogin(){
        return "Login";
    }
    @GetMapping(path = "/manage")
    public String toManage(){
        return "Manage";
    }


}
