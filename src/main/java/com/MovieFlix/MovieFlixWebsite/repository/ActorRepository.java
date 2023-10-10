package com.MovieFlix.MovieFlixWebsite.repository;

import com.MovieFlix.MovieFlixWebsite.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
