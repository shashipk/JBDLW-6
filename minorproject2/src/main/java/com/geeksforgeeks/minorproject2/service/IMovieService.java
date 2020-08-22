package com.geeksforgeeks.minorproject2.service;

import com.geeksforgeeks.minorproject2.model.MovieRequest;
import com.geeksforgeeks.minorproject2.model.MovieResponse;
import com.geeksforgeeks.minorproject2.model.UpdateRating;

public interface IMovieService {
    void create(MovieRequest movieRequest);
    void update(long id, UpdateRating updateRating);
    MovieResponse get(long id);
    void delete( long id);
}
