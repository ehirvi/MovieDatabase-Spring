package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.Genre;
import hh.sof03.moviedatabase.domain.GenreRepository;
import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("/admin/genrelist")
// Security method
public class AdminGenreController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String getAllGenres(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genrelist";
    }

    @GetMapping("/edit/{id}")
    public String editGenre(@PathVariable("id") Long id, Model model) {
        Genre genre = genreRepository.findById(id).get();
        model.addAttribute("genre", genre);
        model.addAttribute("movies", movieRepository.findByGenre(genre));
        return "editgenre";
    }    

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Long id) {
        genreRepository.deleteById(id);
        return "redirect:/admin/genrelist";
    }

    @GetMapping("/add")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "newgenre";
    }

    @PostMapping("/save")
    public String saveGenre(Genre genre) {
        genreRepository.save(genre);
        return "redirect:/admin/genrelist";
    }
}
