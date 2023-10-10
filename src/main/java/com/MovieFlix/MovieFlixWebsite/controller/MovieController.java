package com.MovieFlix.MovieFlixWebsite.controller;

import com.MovieFlix.MovieFlixWebsite.model.Comment;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class MovieController {
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

    @GetMapping("/index")
    public String index(ModelMap modelMap){
    List<Movie> list1=movieServiceImpl.findAll();
    modelMap.addAttribute("listmovie1",list1);
        return "main";
    }
    @GetMapping("des/{id}")
    public String getpagedescription(ModelMap modelMap,
                                     @PathVariable("id") Long id,
                                     HttpSession section,
                                     Principal principal){

        section.setAttribute("movie_id_des",id);
            Movie movie=movieServiceImpl.findById(id);
            String nationname=movie.getNation().getNationname();
            String manu=movie.getManufacturer().getManu_name();
            String catename=movie.getCategory().getName();
            List<Comment> listcomment=commentRepository.getlistcomment(id);
            int comments=listcomment.size();
        List<Movie> list1=movieServiceImpl.findAll();
        modelMap.addAttribute("listmovie1",list1);
        modelMap.addAttribute("newcomment",new Comment());
        modelMap.addAttribute("movie",movie);
        modelMap.addAttribute("username",principal.getName());
            modelMap.addAttribute("nationname",nationname);
            modelMap.addAttribute("manuname",manu);
            modelMap.addAttribute("comments",comments);
            modelMap.addAttribute("listcomment",listcomment);
            modelMap.addAttribute("catename",catename);
        return "des";
    }
    @GetMapping("/watch/{id}")
    public String  watch(@PathVariable("id") Long id,
                         ModelMap modelMap,
                         HttpSession section){

        List<Movie> listsixmovie=movieRepository.getsixmovie();
        modelMap.addAttribute("listsixmovie",listsixmovie);
        Movie movie=movieServiceImpl.findById(id);
        modelMap.addAttribute("movie",movie);
        return "avenger1";
    }

    @GetMapping("/search")
    public String search(ModelMap modelMap
            ,Principal principal
            ,@RequestParam("keyword") String keyword
            ,HttpSession section) {
        System.out.println("This is api search.");
        List<Movie> listmovie1=movieRepository.searchMovie(keyword);
        modelMap.addAttribute("listmovie1",listmovie1);

        return "mainlogined";
    }

    @GetMapping("/search1")
    public String search1(ModelMap modelMap
            ,Principal principal
            ,@RequestParam("keyword") String keyword
            ,HttpSession section) {
        System.out.println("This is api search.");
        List<Movie> listmovie1=movieRepository.searchMovie(keyword);
        modelMap.addAttribute("listmovie1",listmovie1);

        return "des";
    }

    @GetMapping("/search2")
    public String search2(ModelMap modelMap
            ,Principal principal
            ,@RequestParam("keyword") String keyword
            ,HttpSession section) {

        System.out.println("This is api search.");
        Long movie_id=(Long) section.getAttribute("movie_id_des");
        System.out.println("movie_id_des"+movie_id);

        Movie movie=movieServiceImpl.findById(movie_id);

        modelMap.addAttribute("movie",movie);
        List<Movie> listmovie1=movieRepository.searchMovie(keyword);
        modelMap.addAttribute("listmovie1",listmovie1);

        return "avenger1";
    }

    @GetMapping("/year/{start}/{end}")
    public String year(@PathVariable("start") int start,
                       @PathVariable("end") int end,
                       ModelMap modelMap,
                       HttpSession section,
                       Principal principal){

        Long id=(Long)section.getAttribute("movie_id_des");
        Movie movie=movieServiceImpl.findById(id);
        String nationname=movie.getNation().getNationname();
        String manu=movie.getManufacturer().getManu_name();
        String catename=movie.getCategory().getName();
        List<Comment> listcomment=commentRepository.getlistcomment(id);
        int comments=listcomment.size();


        List<Movie> list1=movieRepository.getlistByYear(start,end);
        modelMap.addAttribute("listmovie1",list1);


        modelMap.addAttribute("newcomment",new Comment());
        modelMap.addAttribute("movie",movie);
        modelMap.addAttribute("username",principal.getName());
        modelMap.addAttribute("nationname",nationname);
        modelMap.addAttribute("manuname",manu);
        modelMap.addAttribute("comments",comments);
        modelMap.addAttribute("listcomment",listcomment);
        modelMap.addAttribute("catename",catename);



        return "des";
    }

    @GetMapping("/year1/{start}/{end}")
    public String year1(@PathVariable("start") int start,
                       @PathVariable("end") int end,
                       ModelMap modelMap,
                       HttpSession section,
                       Principal principal){
        if(principal==null){
            return "redirect:/login";
        }
        List<Movie> list1=movieRepository.getlistByYear(start,end);
        modelMap.addAttribute("listmovie1",list1);
        modelMap.addAttribute("username",principal.getName());
        return "mainlogined";
    }



    @GetMapping("/nation/{id}")
    public String getlistByNation(@PathVariable("id") Long id,
                                  ModelMap modelMap,
                                  HttpSession section,
                                  Principal principal){
        if(principal==null){
            return "redirect:/login";
        }
        List<Movie> list1=movieRepository.getlistByNation_id(id);
        modelMap.addAttribute("listmovie1",list1);
        List<Nation> listnation=nationServiceImpl.findAll();
        modelMap.addAttribute("listnation",listnation);

        return "mainlogined";
    }


}
