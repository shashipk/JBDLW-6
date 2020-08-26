package com.example.redis;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("average_rating")
public class ProductRating implements Serializable {
    Long id;
    Double avergaeRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAvergaeRating() {
        return avergaeRating;
    }

    public void setAvergaeRating(Double avergaeRating) {
        this.avergaeRating = avergaeRating;
    }

    public ProductRating() {
    }

}
