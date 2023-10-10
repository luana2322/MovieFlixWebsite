package com.MovieFlix.MovieFlixWebsite.service.Impl;

import com.MovieFlix.MovieFlixWebsite.model.Movie;
import com.MovieFlix.MovieFlixWebsite.repository.MovieRepository;
import com.MovieFlix.MovieFlixWebsite.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }



    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }
}
