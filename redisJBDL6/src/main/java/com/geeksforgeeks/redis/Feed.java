package com.geeksforgeeks.redis;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("feed")
public class Feed {
    String id;
    String description;

    public Feed() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
