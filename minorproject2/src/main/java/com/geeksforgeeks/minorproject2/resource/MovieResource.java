package com.geeksforgeeks.minorproject2.resource;


import com.geeksforgeeks.minorproject2.model.MovieRequest;
import com.geeksforgeeks.minorproject2.model.MovieResponse;
import com.geeksforgeeks.minorproject2.model.UpdateRating;
import com.geeksforgeeks.minorproject2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieResource {
    @Autowired
    MovieService movieService;


    @PreAuthorize("hasAuthority('create_movie')")
    @PostMapping("/movie")
    public ResponseEntity createMovie(@RequestBody MovieRequest movieRequest){
        movieService.create(movieRequest);

        return ResponseEntity.accepted()
                .build();

    }
    @PreAuthorize("hasAuthority('update_movie')")
    @PutMapping("/movie/{movie_id}")
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody UpdateRating updateRating,
                                                     @PathVariable("movie_id") long id ){
        movieService.update(id,updateRating);

        return ResponseEntity.accepted()
                .build();

    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable("movie_id") long id){

        return ResponseEntity
                .ok(movieService.get(id));
    }

    @DeleteMapping("/movie/{movie_id}")
    public ResponseEntity deleteMovie(@PathVariable("movie_id") long id){
        movieService.delete(id);

        return ResponseEntity.accepted()
                .build();

    }

}
