package hh.sof03.moviedatabase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.moviedatabase.webcontrol.AdminDirectorController;
import hh.sof03.moviedatabase.webcontrol.AdminGenreController;
import hh.sof03.moviedatabase.webcontrol.IndexController;
import hh.sof03.moviedatabase.webcontrol.AdminMovieController;
import hh.sof03.moviedatabase.webcontrol.MovieRestController;

@SpringBootTest
class MoviedatabaseApplicationTests {

	@Autowired
	private MovieRestController movieRestController;

	@Autowired
	private AdminMovieController movieController;

	@Autowired
	private IndexController indexController;

	@Autowired
	private AdminGenreController genreController;

	@Autowired
	private AdminDirectorController directorController;

	@Test
	void contextLoads() {
		Assertions.assertThat(movieRestController).isNotNull();
		Assertions.assertThat(movieController).isNotNull();
		Assertions.assertThat(indexController).isNotNull();
		Assertions.assertThat(genreController).isNotNull();
		Assertions.assertThat(directorController).isNotNull();
	}

}
