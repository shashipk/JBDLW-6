package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    @KafkaListener(topics="topic1")
    public void consume(String data){
        logger.info("Consumer received : {}",data);

    }



}
