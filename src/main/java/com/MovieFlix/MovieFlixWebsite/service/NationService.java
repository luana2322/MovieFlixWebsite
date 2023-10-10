package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Nation;

import java.util.List;

public interface NationService {
    public List<Nation> findAll();

    public Nation findById(Long id);
}
