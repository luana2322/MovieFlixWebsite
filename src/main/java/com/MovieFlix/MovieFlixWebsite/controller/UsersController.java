package com.MovieFlix.MovieFlixWebsite.controller;

import com.MovieFlix.MovieFlixWebsite.dto.UserDto;
import com.MovieFlix.MovieFlixWebsite.model.Movie;
import com.MovieFlix.MovieFlixWebsite.model.Nation;
import com.MovieFlix.MovieFlixWebsite.model.Users;
import com.MovieFlix.MovieFlixWebsite.repository.CommentRepository;
import com.MovieFlix.MovieFlixWebsite.repository.MovieRepository;
import com.MovieFlix.MovieFlixWebsite.repository.UsersRepository;
import com.MovieFlix.MovieFlixWebsite.service.Impl.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersServiceImpl usersServiceImpl;

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

    @GetMapping({"/logged","/"})
    public String logined(HttpSession section,
                          Principal principal,
                          ModelMap modelMap) {
        if(principal==null){
            return "redirect:/login";
        }
        List<Movie> list1=movieServiceImpl.findAll();
        modelMap.addAttribute("listmovie1",list1);
        Users user=usersServiceImpl.findByusername(principal.getName());
        section.setAttribute("user_id_local",user.getId());
        List<Nation> listnation=nationServiceImpl.findAll();
        modelMap.addAttribute("listnation",listnation);
        return "mainlogined";
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("title", "Login Page");
        modelMap.addAttribute("user", new Users());

        modelMap.addAttribute("newdto", new UserDto());
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap modelMap) {
        modelMap.addAttribute("title", "Register");
        modelMap.addAttribute("user", new Users());
        modelMap.addAttribute("regispage", "true");
        modelMap.addAttribute("newdto", new UserDto());
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotpassword(ModelMap modelMap) {
        modelMap.addAttribute("title", "Forgot Password!!");
        return "forgot-password";
    }

    @PostMapping("/register-new")
    public String registernew(@Valid UserDto userDto,
                              BindingResult bindingResult,
                              ModelMap modelMap) {

        if (bindingResult.hasErrors()) {

            modelMap.addAttribute("user", new Users());
            modelMap.addAttribute("newdto", new UserDto());
            System.out.println("Looix 1");
            return "login";
        }

        try {
            modelMap.remove("message");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Users user = usersRepository.findByUsername(userDto.getUsername()).isPresent()
                ? usersRepository.findByUsername(userDto.getUsername()).get()
                : null;

        if (user != null) {

            modelMap.addAttribute("user", new Users());
            modelMap.addAttribute("newdto", new UserDto());
            modelMap.addAttribute("message", "Username existed!!");
            System.out.println("Looix 2");
            return "login";
        }

        if (!userDto.getPassword().equals(userDto.getRepeatpassword())) {

            modelMap.addAttribute("user", new Users());
            modelMap.addAttribute("newdto", new UserDto());
            modelMap.addAttribute("message", "Password is not same!!");
            System.out.println("Looix 3");
            return "login";
        }

        usersServiceImpl.save(usersServiceImpl.maptouser(userDto));
        modelMap.addAttribute("user", new Users());

        modelMap.addAttribute("newdto", new UserDto());
        modelMap.remove("regispage");
        return "login";
    }

}
