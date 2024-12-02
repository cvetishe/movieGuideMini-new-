package com.example.NewMovieGuideMini;

public class DesiredMovie {
    String nameMovie;

    public DesiredMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String desiredMovie) {
        this.nameMovie = desiredMovie;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                ", search='" + nameMovie + '\'' +
                '}';
    }
}
