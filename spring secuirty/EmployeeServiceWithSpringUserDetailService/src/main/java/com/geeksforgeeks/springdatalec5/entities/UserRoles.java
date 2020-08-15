package com.geeksforgeeks.springdatalec5.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRoles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;
    private String role;
    @ManyToMany(mappedBy = "userRoles", fetch = FetchType.EAGER)
    private List<MyUser> users;


    @Override
    public String getAuthority() {
        return null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
