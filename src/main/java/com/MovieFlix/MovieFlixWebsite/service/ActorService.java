package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Actor;

import java.util.List;

public interface ActorService {
    public List<Actor> findAll();

    public Actor findById(Long id);

}
