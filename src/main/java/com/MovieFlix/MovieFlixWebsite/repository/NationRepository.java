package com.MovieFlix.MovieFlixWebsite.repository;

import com.MovieFlix.MovieFlixWebsite.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends JpaRepository<Nation,Long> {
}
