package com.example.NewMovieGuideMini;

public class Film {
    String name;
    String type;
    String img;
    String description;
    int id;

    public Film(String name, String type, String img, String description, int id) {
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

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
