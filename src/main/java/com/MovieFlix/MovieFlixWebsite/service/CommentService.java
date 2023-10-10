package com.MovieFlix.MovieFlixWebsite.service;

import com.MovieFlix.MovieFlixWebsite.model.Actor;
import com.MovieFlix.MovieFlixWebsite.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();

    public Comment findById(Long id);

    public Comment save(Comment comment);

    public void deleteById(Long id);

    public Comment update(Comment comment);
}
