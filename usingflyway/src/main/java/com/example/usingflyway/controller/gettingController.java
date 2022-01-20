package com.example.usingflyway.controller;

import com.example.usingflyway.model.movie;
import com.example.usingflyway.service.gettingService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class gettingController {

    @Autowired
    gettingService gs;

    @GetMapping("/getmoviedetails")
    public List<movie> getDetails(){
        return gs.findAll();
    }

    @GetMapping("/getmoviedetails/{movieno}")
    public ResponseEntity <movie> getById(@PathVariable(value = "movieno") int mno){
        movie m = gs.getById(mno);
        return ResponseEntity.ok().body(m);
    }

    @PutMapping("/getmoviedetails/{movieno}")
    public ResponseEntity<movie> updateMovie(@PathVariable(value = "movieno") int mno, @RequestBody movie mdetails){
        movie m = gs.getById(mno);
        m.setName(mdetails.getName());
        m.setGenre(mdetails.getGenre());
        m.setRating(mdetails.getRating());
        movie newm = gs.save(m);
        return ResponseEntity.ok(newm);
    }

    @PostMapping
    public movie saveDetails(@RequestBody movie m){
        return gs.save(m);
    }

    @DeleteMapping("movie/{movieno}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "movieno") int mno) {
        movie m = gs.getById(mno);
        gs.delete(m);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/getmovie/genre/{genre}")
    private List<movie> getMovieByGenre(@PathVariable String genre){
        return gs.getMovieByGenre(genre);
    }
}
