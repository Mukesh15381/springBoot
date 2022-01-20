package com.example.usingflyway.service;

import com.example.usingflyway.model.movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface gettingService extends JpaRepository<movie,Integer> {

    @Query(value = "SELECT * FROM topmovielist mlist WHERE mlist.genre = ?1",nativeQuery = true)
    public List<movie> getMovieByGenre(String genre);


}
