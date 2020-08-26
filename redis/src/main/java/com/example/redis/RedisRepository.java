package com.example.redis;

import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<ProductRating,Long> {
}
