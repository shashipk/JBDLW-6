package com.geeksforgeeks.springsecuritysetup.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories
                .createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
        .and()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")

        ;
    }
    //Authz
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/user")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .and()
                .formLogin();

    }
}
