package com.example.NewMovieGuideMini;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class FilmService {
    List<Film> filmList = new ArrayList<>();
    List<String> toViewsList = new ArrayList<>();


    public List<Film> getFilmList() throws IOException {
        filmList.clear();
        fileRead("films_data.txt");
        return filmList;
    }

    public void fileRead(String file) throws IOException {
        try {
            Scanner read = new Scanner(new File(file));
            int id = 0;
            String name;
            String type;
            String description;
            while (read.hasNext()) {
                String line = read.nextLine();
                name = line.substring(0, line.indexOf("%"));
                type = line.substring(line.indexOf("%") + 1, line.lastIndexOf("%")).trim();
                description = line.substring(line.lastIndexOf("%") + 1);
                id++;
                String str = Integer.toString(id);
                String img = "/images/" + str + ".jpg";
                filmList.add(new Film(name, type, img, description, id));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "файл не загружен");
        }
    }

    public List<String> getTypes(){
        return filmList.stream().map(Film::getType).
                distinct().toList();
    }

    public List<Film> getFilmOfType(String type) throws IOException {
        return filmList.stream()
                .filter(film -> film.getType().equals(type)).
                toList();
    }

    public List<Film> getToViewsList() throws IOException {
        List<Film> toViewFilmList = new ArrayList<>();
        for(String view : toViewsList){
            for(Film film:filmList) {
                if(view.equals(film.name)){
                    toViewFilmList.add(film);
                }
            }
        }return toViewFilmList;
    }

    public Film getFilmId(int id) {
        for (Film film : filmList) {
            if (film.getId() == id) {
                return film;
            }
        }return null;
    }

    public String addFilmId(int id) {
        Film f = getFilmId(id);
        toViewsList.add(f.name);
        return f.name;
    }

    public String getToViewsFilmName(int id) {
        Film film = getFilmId(id);
        for (String view : toViewsList) {
            if (view.equals(film.name)) {
                return view;
            }
        }return null;
    }

    public void deleteFilmId(int id) throws IOException {
        String s = getToViewsFilmName(id);
        if(!s.isEmpty())
            toViewsList.remove(s);
    }
}
