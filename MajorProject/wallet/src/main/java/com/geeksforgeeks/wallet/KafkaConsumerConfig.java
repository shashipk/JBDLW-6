package com.geeksforgeeks.wallet;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public Map<String,Object> conusmerConfig(){
        Map<String,Object> conusmerConfig = new HashMap<>();
        conusmerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        conusmerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        conusmerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EventDeserializer.class);
        return conusmerConfig;
    }

    @Bean
    public ConsumerFactory<String,Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(conusmerConfig());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return concurrentKafkaListenerContainerFactory;

    }
}
