package com.geeksforgeeks.springsecuritysetup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String welcome(){
        return "Welcome!";
    }

    @GetMapping("/user")
    public String userPage(){
        return "Hi User!";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "Hi Admin!";
    }
}
