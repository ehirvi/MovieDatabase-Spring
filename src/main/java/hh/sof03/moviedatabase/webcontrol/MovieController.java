package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("/movielist")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist";
    }

}
