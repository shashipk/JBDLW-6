package com.geeksforgeeks.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    EmailService emailService;
    public void send(String mail ){
        simpleMailMessage.setTo("geekstutorialemail2020@gmail.com");
        simpleMailMessage.setSubject("Test Mail");
        simpleMailMessage.setText(mail);
        javaMailSender.send(simpleMailMessage);

    }


    @KafkaListener(topics = "USER", groupId = "email")
    public void sendMailOnUserChange(Event event ){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserResponse> entity =new HttpEntity<>(headers);

        UserResponse userResponse = restTemplate.exchange("http://localhost:5051/user/"+event.getUser(),
                HttpMethod.GET,
                entity,
                UserResponse.class)
                .getBody();


        simpleMailMessage.setTo(userResponse.getEmail());
        simpleMailMessage.setSubject(event.getName());
        simpleMailMessage.setText(event.getData());
        javaMailSender.send(simpleMailMessage);

    }

    @KafkaListener(topics = "TRANSACTION", groupId = "email")
    public void sendMailOnTx(Event event ){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserResponse> entity =new HttpEntity<>(headers);

        UserResponse userResponse = restTemplate.exchange("http://localhost:5051/user/"+event.getUser(),
                HttpMethod.GET,
                entity,
                UserResponse.class)
                .getBody();


        simpleMailMessage.setTo(userResponse.getEmail());
        simpleMailMessage.setSubject(event.getName());
        simpleMailMessage.setText(event.getData());
        javaMailSender.send(simpleMailMessage);

    }
}
