package com.example.NewMovieGuideMini;

public class UserSearch {
    String user;
    String desiredMovie;

    public UserSearch(String user, String desiredMovie) {
        this.user = user;
        this.desiredMovie = desiredMovie;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSearch() {
        return desiredMovie;
    }

    public void setSearch(String desiredMovie) {
        this.desiredMovie = desiredMovie;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                "user='" + user + '\'' +
                ", search='" + desiredMovie + '\'' +
                '}';
    }
}
