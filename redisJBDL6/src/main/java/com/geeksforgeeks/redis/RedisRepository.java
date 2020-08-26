package com.geeksforgeeks.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Feed,String> {
}

