package com.MovieFlix.MovieFlixWebsite.repository;

import com.MovieFlix.MovieFlixWebsite.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query(value = "select * from Movie limit 6",nativeQuery = true)
    public List<Movie> getsixmovie();

    @Query(value = "SELECT * FROM Movie p WHERE " +
            "p.name LIKE CONCAT('%',:keyword, '%')" +
            "Or p.description LIKE CONCAT('%', :keyword, '%')",nativeQuery = true)
    List<Movie> searchMovie(String keyword);


    @Query(value = "select * from Movie p where p.date_produce BETWEEN ?1 and ?2",nativeQuery = true)
    List<Movie> getlistByYear(int start,int end);

    @Query(value = "select * from Movie p where p.nation_id=?1",nativeQuery = true)
    List<Movie> getlistByNation_id(Long nation_id);

// 2-New;3-Anime,5-Khoa hoc vien tuong
    @Query(value = "select * from Movie p where p.cate_id=?1",nativeQuery = true)
    List<Movie> getlistByCate_id(Long category_id);
}
