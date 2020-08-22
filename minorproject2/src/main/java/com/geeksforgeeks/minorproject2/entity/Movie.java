package com.geeksforgeeks.minorproject2.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "movie_name", nullable = false, unique = true)
    String name;

    @Column(name = "description", nullable = true)
    String description;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "movie_movie_category",
                    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
            )
    List<MovieCategory> movieCategories;
    @Column(name = "rating")
    int rating;

    public Movie(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Movie() {
    }
}
