package com.geeksforgeeks.minorproject2.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MovieResponse implements Serializable {
    private String name;
    private String desc;
    private List<String> categories;
    private int rating;
}
