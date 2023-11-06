package hh.sof03.moviedatabase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.moviedatabase.webcontrol.DirectorController;
import hh.sof03.moviedatabase.webcontrol.GenreController;
import hh.sof03.moviedatabase.webcontrol.IndexController;
import hh.sof03.moviedatabase.webcontrol.MovieController;
import hh.sof03.moviedatabase.webcontrol.MovieRestController;

@SpringBootTest
class MoviedatabaseApplicationTests {

	@Autowired
	private MovieRestController movieRestController;

	@Autowired
	private MovieController movieController;

	@Autowired
	private IndexController indexController;

	@Autowired
	private GenreController genreController;

	@Autowired
	private DirectorController directorController;

	@Test
	void contextLoads() {
		Assertions.assertThat(movieRestController).isNotNull();
		Assertions.assertThat(movieController).isNotNull();
		Assertions.assertThat(indexController).isNotNull();
		Assertions.assertThat(genreController).isNotNull();
		Assertions.assertThat(directorController).isNotNull();
	}

}
