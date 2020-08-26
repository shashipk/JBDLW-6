package com.example.redis;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}

