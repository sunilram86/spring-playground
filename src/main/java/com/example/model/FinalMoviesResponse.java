package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class FinalMoviesResponse {

    private  String title;

    private  String imdbId;

    private String poster;

    private int year;

    public FinalMoviesResponse() {
    }

    public FinalMoviesResponse(String title, String imdbId, String poster, int year) {
        this.title = title;
        this.imdbId = imdbId;
        this.poster = poster;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "FinalMoviesResponse{" +
                "title='" + title + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", poster='" + poster + '\'' +
                ", year=" + year +
                '}';
    }
}

