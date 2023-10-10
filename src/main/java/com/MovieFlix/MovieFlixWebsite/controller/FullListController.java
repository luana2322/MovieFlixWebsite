package com.MovieFlix.MovieFlixWebsite.controller;

import com.MovieFlix.MovieFlixWebsite.model.Movie;
import com.MovieFlix.MovieFlixWebsite.model.Nation;
import com.MovieFlix.MovieFlixWebsite.model.Users;
import com.MovieFlix.MovieFlixWebsite.repository.CommentRepository;
import com.MovieFlix.MovieFlixWebsite.repository.MovieRepository;
import com.MovieFlix.MovieFlixWebsite.service.Impl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class FullListController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieServiceImpl movieServiceImpl;
    @Autowired
    private NationServiceImpl nationServiceImpl;
    @Autowired
    private ManufacturerServiceImpl manufacturerServiceImpl;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private CommentServiceImpl commentServiceImpl;
    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("/fulllist")
    public String danhsach(HttpSession section,
                          Principal principal,
                          ModelMap modelMap) {
        if(principal==null){
            return "redirect:/login";
        }
        System.out.println("This is fullList Page");
        List<Movie> list1=movieServiceImpl.findAll();
        modelMap.addAttribute("listmovie1",list1);
        List<Nation> listnation=nationServiceImpl.findAll();
        modelMap.addAttribute("listnation",listnation);

// 2-New;3-Anime,5-Khoa hoc vien tuong


        Long num1= 2L;
        List<Movie> listnew=movieRepository.getlistByCate_id(num1);
        modelMap.addAttribute("listnew",listnew);
        Long num2= 3L;
        List<Movie> listanime=movieRepository.getlistByCate_id(num2);
        modelMap.addAttribute("listanime",listanime);
        Long num3= 5L;
        List<Movie> listkh=movieRepository.getlistByCate_id(num3);
        modelMap.addAttribute("listkh",listkh);


        return "fulllist";
    }
}
