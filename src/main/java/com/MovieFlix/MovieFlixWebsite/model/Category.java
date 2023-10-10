package com.MovieFlix.MovieFlixWebsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long cate_id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
    private List<Movie>  movie;
}
