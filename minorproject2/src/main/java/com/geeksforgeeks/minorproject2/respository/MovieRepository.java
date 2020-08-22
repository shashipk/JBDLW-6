package com.geeksforgeeks.minorproject2.respository;

import com.geeksforgeeks.minorproject2.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {
}
