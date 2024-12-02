package com.example.NewMovieGuideMini;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class AccountingUserRequests {

    List<DesiredMovie> desiredMoviesList = new ArrayList<>();

    public String addMovie(String movie) {
        desiredMoviesList.add(new DesiredMovie(movie));
        return movie;
    }

    public List<DesiredMovie> getUserMovie(String movies) {
        return desiredMoviesList;
    }

    public void save() throws IOException {
        String fileName = "user_movie_data.txt";
        List<String> lines = desiredMoviesList.stream()
                .map(DesiredMovie::getNameMovie).sorted().toList();
        Path file = Paths.get(fileName);
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

}