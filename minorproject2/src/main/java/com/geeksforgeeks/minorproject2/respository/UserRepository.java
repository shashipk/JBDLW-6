package com.geeksforgeeks.minorproject2.respository;

import com.geeksforgeeks.minorproject2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}