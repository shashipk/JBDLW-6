package com.geeksforgeeks.wallet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class EventDeserializer implements Deserializer<Event> {
    Boolean isKey;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.isKey=isKey;

    }

    @Override
    public Event deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(new String(bytes, "UTF-8"),Event.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
