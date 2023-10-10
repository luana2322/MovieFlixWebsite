package com.MovieFlix.MovieFlixWebsite.service.Impl;

import com.MovieFlix.MovieFlixWebsite.model.Category;
import com.MovieFlix.MovieFlixWebsite.repository.CategoryRepository;
import com.MovieFlix.MovieFlixWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
