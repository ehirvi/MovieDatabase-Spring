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

@SpringBootApplication
public class MoviedatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(MoviedatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepo, GenreRepository genreRepo, DirectorRepository directorRepo) {
		return (args) -> {
			Director director1 = directorRepo.save(new Director("Christopher Nolan", "null"));
			Genre genre1 = genreRepo.save(new Genre("Sci-Fi"));
			Movie movie1 = movieRepo.save(new Movie("Interstellar", "desc", "img", 2014, director1 , genre1));

			Director director2 = directorRepo.save(new Director("Ridley Scott", "null"));
			Genre genre2 = genreRepo.save(new Genre("Historical"));
			Movie movie2 = movieRepo.save(new Movie("Gladiator", "desc", "img", 2000, director2, genre2));

			log.info("succesful");
		};
	}

}
