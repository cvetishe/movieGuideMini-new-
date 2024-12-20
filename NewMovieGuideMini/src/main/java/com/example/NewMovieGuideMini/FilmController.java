package com.example.NewMovieGuideMini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;

@Controller
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    AccountingUserRequests userRequests;


    @GetMapping({"/","/allFilms","/movie"})
    public String getAllFilms(Model model) throws IOException {
        model.addAttribute("lines",
                filmService.getFilmList());
        model.addAttribute("type",
                filmService.getTypes());
        return "allFilms";
    }

    @GetMapping("/addMovie")
    public String getREsultMovie(String movie, Model model){
        if(!movie.isEmpty()) {
            userRequests.addMovie(movie);
            return "redirect:/";
        }
        return "allFilms";
    }

    @GetMapping("/line/{id}")
    public String getFilmId(@PathVariable int id, Model model) {
        Film film = filmService.getFilmId(id);
        if (film != null) {
            model.addAttribute("line", film);
            return "pageFilm";
        }
        model.addAttribute("type",
                filmService.getTypes());
        return "allFilms";
    }

    @GetMapping("/toView")
    public String getToViewAllList(Model model) throws IOException {
        model.addAttribute("lines",
                filmService.getToViewsList());
        if(filmService.getToViewsList().isEmpty()){
            model.addAttribute("mistake");
        }
        return "toView";
    }

    @GetMapping("/add")
    public String addFilmToView(int id, Model model) {
        String l = filmService.addFilmId(id);
        if (!l.isEmpty()) {
            model.addAttribute("line",
                    filmService.getFilmId(id));
            return "add";
        }
        model.addAttribute("type",
                filmService.getTypes());
        return "allFilms";
    }

    @GetMapping("/delete")
    public String deleteToViewFilm(int id, Model model){
        try {
            String s = filmService.getToViewsFilmName(id);
            if (!s.isEmpty()) {
                filmService.deleteFilmId(id);
                model.addAttribute("line", s);
                return "deleteFilm";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.addAttribute("type",
                filmService.getTypes());
        return "allFilms";
    }

    @GetMapping("/type/{type}")
    public String getFilmsOfType(@PathVariable String type,
                                 Model model) throws IOException {
        filmService.getTypes();
        model.addAttribute("type",
                filmService.getTypes());
        model.addAttribute("lines",
                filmService.getFilmOfType(type));
        return "allFilms";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("tab_movies",
                userRequests.desiredMoviesList);
        return "admin";
    }

    @GetMapping("/save")
    public String saveResult(Model model){
        try{
            userRequests.save();
            model.addAttribute("massage",
                    "сохранено");
        } catch (IOException e){
            model.addAttribute("massage",
                    e.getMessage());
        }
        return "admin";
    }

}
