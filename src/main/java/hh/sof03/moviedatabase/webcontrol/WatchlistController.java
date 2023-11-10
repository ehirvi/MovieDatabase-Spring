package hh.sof03.moviedatabase.webcontrol;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;
import hh.sof03.moviedatabase.domain.User;
import hh.sof03.moviedatabase.domain.UserRepository;
import hh.sof03.moviedatabase.domain.Watchlist;
import hh.sof03.moviedatabase.domain.WatchlistRepository;

@Controller
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WatchlistRepository watchlistRepository;


    @GetMapping
    public String watchList(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("watchlist", user.getWatchlist());
        return "watchlist";
    }

    @GetMapping("/add/{id}")
    public String addMovie(@PathVariable("id") Long id, Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        Movie movie = movieRepository.findById(id).get();
        if (watchlistRepository.findByMovieAndUser(movie, user) == null) {
            watchlistRepository.save(new Watchlist(user, movie));
        }
        return "redirect:/watchlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Movie movie = movieRepository.findById(id).get();
        Watchlist watchlist = watchlistRepository.findByMovieAndUser(movie, user);
        watchlistRepository.deleteById(watchlist.getId());
        return "redirect:/watchlist";
    }

}
