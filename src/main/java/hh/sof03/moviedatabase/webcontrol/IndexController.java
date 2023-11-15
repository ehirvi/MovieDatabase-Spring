package hh.sof03.moviedatabase.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.MovieRepository;
import hh.sof03.moviedatabase.domain.RegisterForm;
import hh.sof03.moviedatabase.domain.User;
import hh.sof03.moviedatabase.domain.UserRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String indexPage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerform", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String userRegister(@Valid @ModelAttribute("registerform") RegisterForm registerForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (registerForm.getPassword().equals(registerForm.getPasswordCheck())) {
                String pwd = registerForm.getPassword();
                BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
                String hashPwd = bpe.encode(pwd);

                User user = new User();
                user.setPasswordHash(hashPwd);
                user.setUsername(registerForm.getUsername());
                user.setRole("USER");
                if (userRepository.findByUsername(registerForm.getUsername()) == null) {
                    userRepository.save(user);
                } else {
                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "register";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
                return "register";
            }
        } else {
            return "register";
        }
        return "redirect:/login";
    }

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "movie";
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "adminpanel";
    }
}
