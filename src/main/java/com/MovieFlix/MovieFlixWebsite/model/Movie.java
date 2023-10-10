package com.MovieFlix.MovieFlixWebsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movie_id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private int date_produce;
    private int time;
    private int updated_date;
    private String image_link;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id")
    private Nation nation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manu_id", referencedColumnName = "manu_id")
    private Manufacturer manufacturer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id",
                    referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"
                    , referencedColumnName = "actor_id"))
    private Collection<Actor> actors;

    @OneToMany(mappedBy = "movie",cascade=CascadeType.ALL)
    private List<Comment> comment;
}
