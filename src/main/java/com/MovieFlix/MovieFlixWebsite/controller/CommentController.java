package com.MovieFlix.MovieFlixWebsite.controller;

import com.MovieFlix.MovieFlixWebsite.model.Comment;
import com.MovieFlix.MovieFlixWebsite.model.Movie;
import com.MovieFlix.MovieFlixWebsite.model.Users;
import com.MovieFlix.MovieFlixWebsite.service.Impl.CommentServiceImpl;
import com.MovieFlix.MovieFlixWebsite.service.Impl.MovieServiceImpl;
import com.MovieFlix.MovieFlixWebsite.service.Impl.UsersServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;
    @Autowired
    private MovieServiceImpl movieServiceImpl;
    @Autowired
    private UsersServiceImpl usersServiceImpl;


    @PostMapping("/add-comment")
    public String savecomment(@ModelAttribute("comment")Comment comment,
                              ModelMap modelMap,
                              Principal principal,
                              HttpSession section){

        if(principal==null){
            return "redirect:/login";
        }
    Long user_id_local=(Long) section.getAttribute("user_id_local");
    Long movie_id_local=(Long) section.getAttribute("movie_id_des");

        Movie movie=movieServiceImpl.findById(movie_id_local);
        Users user=usersServiceImpl.findById(user_id_local);

        comment.setMovie(movie);
        comment.setUsers(user);
            commentServiceImpl.save(comment);
        return "redirect:/des/"+movie_id_local;
    }

}
