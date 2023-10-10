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
@Table(name = "nation")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nation_id")
    private Long nation_id;

    private String nationname;

    @OneToMany(mappedBy = "nation",cascade=CascadeType.ALL)
    private List<Movie> movie;
}
