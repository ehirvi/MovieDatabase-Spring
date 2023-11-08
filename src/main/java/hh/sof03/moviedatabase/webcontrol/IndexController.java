package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String frontPage(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "frontpage";
    }

    
    @GetMapping("/admin")
    // Security method
    public String adminPanel() {
        return "adminpanel";
    }
}
