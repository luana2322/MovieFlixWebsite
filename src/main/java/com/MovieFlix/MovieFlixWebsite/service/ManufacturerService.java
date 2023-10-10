package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    public List<Manufacturer> findAll();
    public Manufacturer findById(Long id);
}
