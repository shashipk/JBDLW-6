package com.geeksforgeeks.emailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;
    @PostMapping("/email")
    void sendMail(@RequestBody String mail){
        emailService.send(mail);
    }

}
