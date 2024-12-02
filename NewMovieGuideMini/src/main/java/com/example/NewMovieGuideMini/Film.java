package com.example.NewMovieGuideMini;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Film {
    String name;
    String type;
    String img;
    String description;
    @Id
    int id;

    public Film(){

    }

    public Film(String name, String type, String img,
                String description, int id) {
        this.name = name;
        this.type = type;
        this.img = img;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
