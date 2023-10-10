package com.MovieFlix.MovieFlixWebsite.service.Impl;

import com.MovieFlix.MovieFlixWebsite.model.Actor;
import com.MovieFlix.MovieFlixWebsite.repository.ActorRepository;
import com.MovieFlix.MovieFlixWebsite.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).get();
    }
}
