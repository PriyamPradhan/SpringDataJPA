package com.priyam.springdatajpa.repository;

import com.priyam.springdatajpa.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

    @Query("select s from Game s where s.title=?1")
    List<Game> findByTitle(String title);

    List<Game> findByRating(double rating);

    List<Game> findByRatingGreaterThan(double v);

}
