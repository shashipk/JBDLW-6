package com.geeksforgeeks.usermanagementservice;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Transactional
    @PostMapping("/user")
    void create(@RequestBody UserRequest userRequest){
        userService.create(userRequest);
    }


    @GetMapping("/user/{username}")
    UserResponse get(@PathVariable("username") String username) throws NotFoundException {
        return  userService.get(username);
    }


    @PutMapping("/user/{username}")
    void update(@RequestBody UserRequest userRequest,
                        @PathVariable("username") String username) throws NotFoundException {
          userService.update(userRequest,username);
    }
}
