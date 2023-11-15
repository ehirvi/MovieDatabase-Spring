package hh.sof03.moviedatabase.webcontrol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @Value("${upload.path}")
    private String IMG_DIR;

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
    public String saveEditedMovie(@Valid @ModelAttribute("movie") Movie movie, @RequestParam("imgfile") MultipartFile file, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("directors", directorRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "editmovie";
        }
        if (!file.isEmpty()) {
            try {
                if (movie.getImgFile().length() != 0) {
                    Path path = Paths.get(IMG_DIR + movie.getImgFile());
                    Files.delete(path);
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(IMG_DIR + file.getOriginalFilename());
                Files.write(path, bytes);
                movie.setImgFile(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    public String saveNewMovie(@Valid @ModelAttribute("movie") Movie movie, @RequestParam("imgfile") MultipartFile file, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("directors", directorRepository.findAll());
            model.addAttribute("genres", genreRepository.findAll());
            return "newmovie";
        }

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(IMG_DIR + file.getOriginalFilename());
                Files.write(path, bytes);
                movie.setImgFile(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        movieRepository.save(movie);
        return "redirect:/admin/movielist";
    }

}
