package com.MovieFlix.MovieFlixWebsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actor_id;
    private String name;
    private boolean gender;
    private int age;


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "actor_movies",
//              joinColumns = @JoinColumn(name = "actor_id",
//              referencedColumnName = "actor_id"),
//    inverseJoinColumns = @JoinColumn(name = "movie_id"
//            , referencedColumnName = "movie_id"))
//    private Collection<Movie> movies;


}
