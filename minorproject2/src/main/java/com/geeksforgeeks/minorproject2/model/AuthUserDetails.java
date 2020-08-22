package com.geeksforgeeks.minorproject2.model;

import com.geeksforgeeks.minorproject2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDetails  extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        this.getRoles()
                .forEach(roles -> {
                    grantedAuthorities.add(new SimpleGrantedAuthority(roles.getName()));
                    roles.getPermissions()
                            .forEach(permissions -> {
                                grantedAuthorities.add(new SimpleGrantedAuthority(permissions.getPermission()));
                            });
                });
        return grantedAuthorities;
    }

    public AuthUserDetails(User user) {
        super(user);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
