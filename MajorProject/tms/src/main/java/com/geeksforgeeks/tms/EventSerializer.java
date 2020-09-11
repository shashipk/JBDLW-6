package com.geeksforgeeks.tms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class EventSerializer  implements Serializer<Event> {
    Boolean isKey;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.isKey = isKey;

    }

    @Override
    public byte[] serialize(String s, Event event) {
        try {
            return objectMapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
