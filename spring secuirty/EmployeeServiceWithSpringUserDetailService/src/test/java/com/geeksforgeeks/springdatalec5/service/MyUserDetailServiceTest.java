package com.geeksforgeeks.springdatalec5.service;


import com.geeksforgeeks.springdatalec5.entities.MyUser;
import com.geeksforgeeks.springdatalec5.repository.UserRepository;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MyUserDetailServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private MyUserDetailService userDetailService;


    @org.junit.Test
    public void loadUserByUsername() {
        MyUser myUser = new MyUser();
        myUser.setUsername("username");
        myUser.setPassword("password");
        myUser.setUserRoles(new ArrayList<>());
        Mockito.when(userRepository.findByUsername(any())).thenReturn(myUser);
        UserDetails userDetails = userDetailService.loadUserByUsername("username");
        Assert.assertEquals(userDetails.getUsername(),("username"));
    }

    @org.junit.Test
    public void loadUserByUsernameNegative() {

        MyUser myUser = new MyUser();
        myUser.setUsername("username");
        myUser.setPassword("password");
        myUser.setUserRoles(new ArrayList<>());

        Mockito.when(userRepository.findByUsername(any())).thenReturn(myUser);


        UserDetails userDetails = userDetailService.loadUserByUsername("username");
        Assert.assertNotEquals(userDetails.getPassword(),"password");

    }
}