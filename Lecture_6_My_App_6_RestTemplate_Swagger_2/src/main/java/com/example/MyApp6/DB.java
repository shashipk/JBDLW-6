package com.example.MyApp6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {

    HashMap<String, String> storage =
            new HashMap<>();

    ArrayList<User> userTable =
            new ArrayList<>();

    public DB(){
        storage.put("Sachin","A Great Batsman");
        storage.put("Ramu","A nice Guy");

        userTable.add(new User(1,"Raka",24));
        userTable.add(new User(2,"Saka",30));
    }

    public String searchAWord(String word){
        return storage.get(word);
    }

    public boolean addAUser(User user){
        userTable.add(user);
        return true;
    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public User seachAUser(String userName){
        for(User user: userTable){
            if(user.getName().equals(userName)){
                return user;
            }
        }
        System.out.println("Could not find that user");
        return null;
    }

    public boolean updateAUser(User newUser){
        for(User user : userTable){
            if(user.getId()==newUser.getId()){
                user.setAge(newUser.getAge());
                user.setName(newUser.getName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteAUser(int id){
        for(User user : userTable){
            if(user.getId()==id){
                userTable.remove(user);
                return true;
            }
        }
        return false;
    }


    public User searchAUserById(int id) {
        for(User user : userTable){
            if(user.getId()==id){
                return user;

            }
        }
        return null;
    }
}
