package com.geeksforgeeks.springdatalec5.repository;

import com.geeksforgeeks.springdatalec5.entities.MyUser;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<MyUser,Long> {

    public MyUser findByUsername(String username);
}
