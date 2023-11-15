package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.DirectorRepository;
import hh.sof03.moviedatabase.domain.GenreRepository;
import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/movielist")
public class AdminMovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "editmovie";
    }

    @PostMapping("/edit/save")
    public String saveEditedMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("directors", directorRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "editmovie";
        }
        movieRepository.save(movie);
        return "redirect:/admin/movielist";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieRepository.deleteById(id);
        return "redirect:/admin/movielist";
    }

    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "newmovie";
    }

    @PostMapping("/add/save")
    public String saveNewMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("directors", directorRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "newmovie";
        }
        movieRepository.save(movie);
        return "redirect:/admin/movielist";
    }

}
