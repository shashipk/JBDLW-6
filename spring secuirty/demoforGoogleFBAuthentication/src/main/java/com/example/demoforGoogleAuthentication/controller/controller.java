package com.example.demoforGoogleAuthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping("/")
    public String welcome(){
        return "Welcome. You have logged in.";

    }
}
