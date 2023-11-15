package hh.sof03.moviedatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.moviedatabase.domain.Director;
import hh.sof03.moviedatabase.domain.DirectorRepository;
import hh.sof03.moviedatabase.domain.Genre;
import hh.sof03.moviedatabase.domain.GenreRepository;
import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;
import hh.sof03.moviedatabase.domain.User;
import hh.sof03.moviedatabase.domain.UserRepository;

@SpringBootApplication
public class MoviedatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(MoviedatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepo, GenreRepository genreRepo, DirectorRepository directorRepo, UserRepository userRepo) {
		return (args) -> {
			genreRepo.save(new Genre("Sci-Fi"));
			genreRepo.save(new Genre("Historical"));
			genreRepo.save(new Genre("Fantasy"));
			genreRepo.save(new Genre("Action"));
			genreRepo.save(new Genre("Adventure"));
			genreRepo.save(new Genre("Horror"));

			directorRepo.save(new Director("Ridley Scott"));
			directorRepo.save(new Director("Christopher Nolan"));
			directorRepo.save(new Director("Peter Jackson"));
			directorRepo.save(new Director("George Lucas"));
			directorRepo.save(new Director("James Cameron"));

			movieRepo.save(new Movie("Gladiator", "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.", "ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg", 2000, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Action")));
			movieRepo.save(new Movie("Kingdom of Heaven", "Balian of Ibelin travels to Jerusalem during the Crusades of the 12th century, and there he finds himself as the defender of the city and its people.", "uk55nBEFIQFveIiy9jvLGiVtk4h.jpg", 2005, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Adventure")));
			movieRepo.save(new Movie("Alien", "The crew of a commercial spacecraft encounters a deadly lifeform after investigating an unknown transmission.", "vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg", 1979, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Horror")));
			movieRepo.save(new Movie("Blade Runner", "A blade runner must pursue and terminate four replicants who stole a ship in space and have returned to Earth to find their creator.", "63N9uy8nd9j7Eog2axPQ8lbr3Wj.jpg", 1982, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Sci-Fi")));
			
			// movieRepo.save(new Movie("Interstellar", "desc", "img", 2014, director1 , genre1));

			userRepo.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepo.save(new User("admin", "$2a$10$g7LYNNvVePos9SFcMlsSKOtUbEMhBnm/uRUr3EWDXw36E5sEfGfbm", "ADMIN"));

			log.info("succesful");
		};
	}

}
