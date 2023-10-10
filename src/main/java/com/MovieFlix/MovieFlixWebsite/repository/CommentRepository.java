package com.MovieFlix.MovieFlixWebsite.repository;

import com.MovieFlix.MovieFlixWebsite.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from Comment c where c.movie_id=?1", nativeQuery = true)
    List<Comment> getlistcomment(Long movie_id_local);

}
