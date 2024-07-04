package com.example.popularmovie;

public class Movie {
    private String title;
    private String poster;
    private Double rating;
    private String overview;

    public Movie(String title, String poster, Double rating, String overview)
    {
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
