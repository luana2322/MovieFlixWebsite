package com.MovieFlix.MovieFlixWebsite.service.Impl;

import com.MovieFlix.MovieFlixWebsite.model.Manufacturer;
import com.MovieFlix.MovieFlixWebsite.repository.ManufacturerRepository;
import com.MovieFlix.MovieFlixWebsite.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return manufacturerRepository.findById(id).get();
    }
}
