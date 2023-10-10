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
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manu_id")
    private Long id;
    private String manu_name;
    private String description;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="nation_id",referencedColumnName = "nation_id")
//    private Nation nation;

    @OneToMany(mappedBy = "manufacturer",cascade=CascadeType.ALL)
    private List<Movie> movie;

}
