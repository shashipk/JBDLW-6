package com.example.MyApp6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    DB db = new DB();

    @GetMapping("/hi")
    public String sayHello(){
        return "Hello coders !!";
    }

    //https://www.google.com/search?q=sachin
    // http://localhost:8080/convert_to_INR?usd=6
    @GetMapping("/convert_to_INR")
    public int convert(@RequestParam int usd){
        //int usd = q;
        return usd * 75;
    }
////https://www.google.com/search?q=sachin
    // http://localhost:8080/seacrh?q=Sachin

    @GetMapping("/seacrh")
    public String search(@RequestParam String q){

        return db.searchAWord(q);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return db.getAllUsers();
    }

    //http://localhost:8080/seacrh_user?q=Raka
    @GetMapping("/seacrh_user")
    public User searchUser(@RequestParam String q){

        return db.seachAUser(q);
    }

    //http://localhost:8080/seacrh?q=Sachin
    //http://localhost:8080/seacrh_user?q=Raka -- query param
    //http://localhost:8080/seacrh_user/Raka -- Path Param
    @GetMapping("/seacrh_user/{user_name}")
    public User searchUser2(@PathVariable String user_name){

        return db.seachAUser(user_name);
    }


    // post api for creating a new User in DB
    @PostMapping("/users")
    public boolean createUser(@RequestBody User user){
        return db.addAUser(user);
    }

    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user){
        return db.updateAUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getAUser3(@PathVariable int id){
        User user = db.searchAUserById(id);
        MultiValueMap<String,String> headers =
                new LinkedMultiValueMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("my-val-1");
        list.add("my-val-2");
        headers.put("my-header",list);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("spring -1");
        headers.put("server",list2);


        ResponseEntity<User> responseEntity =
                new ResponseEntity<User>(user,headers, HttpStatus.CREATED);
        return responseEntity;


    }
}
