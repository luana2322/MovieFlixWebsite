package com.MovieFlix.MovieFlixWebsite.service.Impl;

import com.MovieFlix.MovieFlixWebsite.model.Nation;
import com.MovieFlix.MovieFlixWebsite.repository.NationRepository;
import com.MovieFlix.MovieFlixWebsite.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;

    @Override
    public List<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).get();
    }
}
