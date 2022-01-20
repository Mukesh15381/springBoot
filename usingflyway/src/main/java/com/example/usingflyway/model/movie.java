package com.example.usingflyway.model;

import javax.persistence.*;

@Entity
@Table(name = "topmovielist")
public class movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieno")
    private int movieno;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private int rating;

    public int getMovieno() {
        return movieno;
    }

    public void setMovieno(int movieno) {
        this.movieno = movieno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
