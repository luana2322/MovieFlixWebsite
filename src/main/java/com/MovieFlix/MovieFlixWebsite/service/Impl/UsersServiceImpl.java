package com.MovieFlix.MovieFlixWebsite.service.Impl;


import com.MovieFlix.MovieFlixWebsite.dto.UserDto;
import com.MovieFlix.MovieFlixWebsite.model.Users;
import com.MovieFlix.MovieFlixWebsite.repository.UsersRepository;
import com.MovieFlix.MovieFlixWebsite.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public Users findByusername(String username) {
        return usersRepository.findByUsername(username).get();
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).get();
    }

    public Users maptouser(UserDto userDto) {
        return new Users(userDto.getUsername(),userDto.getPassword());
    }
}
