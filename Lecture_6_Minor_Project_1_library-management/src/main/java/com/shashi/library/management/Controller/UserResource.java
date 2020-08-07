package com.shashi.library.management.Controller;

import com.shashi.library.management.DataAccessLayer.User;
import com.shashi.library.management.DataAccessLayer.UserRepository;
import com.shashi.library.management.Util.UserValidator;
import com.shashi.library.management.exception.UserNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class UserResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;
    // Find
    @GetMapping("/v1/users")
    List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/v2/users")
    List<User> findAll2() {
        return repository.findAll();
    }

    @ApiOperation("This Api will create a new user")
    @PostMapping("/users")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        UserValidator validator = new UserValidator();
        if(validator.isValid(newUser))
        return repository.save(newUser);
        return null; // Throw BadRequestException
    }

    // Find a given user
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        /*
      Optional<User> user = repository.findById(id);
       if(user.isPresent()){
           return user.get();
       }
       return null;

         */


        return repository.findById(id)
         .orElseThrow(() -> new UserNotFoundException(id));

    }

}
