package hh.sof03.moviedatabase.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieRestController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMoviesRest() {
        return (List<Movie>) movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> findMovieRest(@PathVariable("id") Long id) {
        return movieRepository.findById(id);
    }

    // @PostMapping
    // public Movie addNewMovieRest(@RequestBody Movie movie) {
    //     return movieRepository.save(movie);
    // }
}
