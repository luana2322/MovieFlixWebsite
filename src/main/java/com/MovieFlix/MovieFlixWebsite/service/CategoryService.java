package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Actor;
import com.MovieFlix.MovieFlixWebsite.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category findById(Long id);
}
