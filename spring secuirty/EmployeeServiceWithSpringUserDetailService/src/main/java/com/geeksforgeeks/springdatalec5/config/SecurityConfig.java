package com.geeksforgeeks.springdatalec5.config;

import com.geeksforgeeks.springdatalec5.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailService getUserDetail(){
        return new MyUserDetailService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(getUserDetail())
                .passwordEncoder(getEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/department")
                .hasRole("ADMIN")
                .antMatchers("/employee")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET)
                .hasAnyRole("USER","ADMIN")
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable();
    }
}
