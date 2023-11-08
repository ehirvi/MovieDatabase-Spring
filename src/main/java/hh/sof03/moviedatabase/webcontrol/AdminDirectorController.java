package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.Director;
import hh.sof03.moviedatabase.domain.DirectorRepository;
import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("/admin/directorlist")
// Security method
public class AdminDirectorController {
    
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping
    public String getAllDirectors(Model model) {
        model.addAttribute("directors", directorRepository.findAll());
        return "directorlist";
    }

    @GetMapping("/edit/{id}")
    public String editDirector(@PathVariable("id") Long id, Model model) {
        Director director = directorRepository.findById(id).get();
        model.addAttribute("director", director);
        model.addAttribute("movies", movieRepository.findByDirector(director));
        return "editdirector";
    }

    @GetMapping("/delete/{id}")
    public String deleteDirector(@PathVariable("id") Long id) {
        directorRepository.deleteById(id);
        return "redirect:/admin/directorlist";
    }

    @GetMapping("/add")
    public String addDirector(Model model) {
        model.addAttribute("director", new Director());
        return "newdirector";
    }

    @PostMapping("/save")
    public String saveDirector(Director director) {
        directorRepository.save(director);
        return "redirect:/admin/directorlist";
    }

}
