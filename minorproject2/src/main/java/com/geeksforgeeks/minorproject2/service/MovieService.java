package com.geeksforgeeks.minorproject2.service;

import com.geeksforgeeks.minorproject2.entity.Movie;
import com.geeksforgeeks.minorproject2.entity.MovieCategory;
import com.geeksforgeeks.minorproject2.model.MovieRequest;
import com.geeksforgeeks.minorproject2.model.MovieResponse;
import com.geeksforgeeks.minorproject2.model.UpdateRating;
import com.geeksforgeeks.minorproject2.respository.MovieCategoryRepository;
import com.geeksforgeeks.minorproject2.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Override
    public void create(MovieRequest movieRequest) {
        List<MovieCategory> movieCategories = new ArrayList<>();
        movieRequest
                .getCategories()
                .forEach(cat ->{
                    MovieCategory movieCategory
                            = movieCategoryRepository
                            .findMovieCategoriesByName(cat).get();
                    movieCategories.add(movieCategory);
                });
        Movie movie = Movie
                .builder()
                .name(movieRequest.getName())
                .description(movieRequest.getDesc())
                .movieCategories(movieCategories)
                .build();
        movieRepository.save(movie);
    }

    @Override
    public void update(long id, UpdateRating updateRating) {
        Movie movie = movieRepository.findById(id).get();
        movie.setRating(updateRating.getRating());
        movieRepository.save(movie);

    }

    @Override
    public MovieResponse get(long id) {
        Movie movie = movieRepository.findById(id).get();
        List<String> categories = new ArrayList();
        movie
                .getMovieCategories()
                .forEach(cat ->{
                    categories.add(cat.getName());
                });

        return MovieResponse
                .builder()
                .name(movie.getName())
                .desc(movie.getDescription())
                .rating(movie.getRating())
                .categories(categories)
                .build();
    }

    @Override
    public void delete(long id) {
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
    }
}
