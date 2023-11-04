package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.DirectorRepository;
import hh.sof03.moviedatabase.domain.GenreRepository;
import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("/movielist")
public class MovieController {

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

    @GetMapping("/{id}")
    public String findMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "movie";
    }

    @PostMapping("/save")
    public String saveMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movielist";
    }

}
