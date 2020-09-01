package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    public void send(String message){
        kafkaTemplate.send("topic1",message);
    }



}
