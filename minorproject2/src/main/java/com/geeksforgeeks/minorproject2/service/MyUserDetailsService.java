package com.geeksforgeeks.minorproject2.service;

import com.geeksforgeeks.minorproject2.model.AuthUserDetails;
import com.geeksforgeeks.minorproject2.respository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AuthUserDetails(userRepository.findByUsername(username));
    }
}
