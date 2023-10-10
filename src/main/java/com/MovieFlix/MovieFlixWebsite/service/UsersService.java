package com.MovieFlix.MovieFlixWebsite.service;


import com.MovieFlix.MovieFlixWebsite.model.Users;

public interface UsersService {
    public Users save(Users user);
    public Users findByusername(String username);

    public Users findById(Long id);


}
