package com.example.MyApp6;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GitHubUserController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("gitHub/users/{login}")
    public ResponseEntity<GitHubUser> getGitHubUserDetail(@PathVariable String login){
        //https://api.github.com/users/+login
        ResponseEntity<GitHubUser> response =
                restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);

        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        return response;

    }

}
