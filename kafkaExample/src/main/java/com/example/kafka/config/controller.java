package com.example.kafka.config;

import com.example.kafka.ProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    ProducerService kafkaProducer;
    @PostMapping("/kafka")
    public void sendMessage(@RequestBody String message){

        kafkaProducer.send(message);
    }

}
