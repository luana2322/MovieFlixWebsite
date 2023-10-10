package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();

    public Movie findById(Long id);

}
