package hh.sof03.moviedatabase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.moviedatabase.webcontrol.MovieController;
import hh.sof03.moviedatabase.webcontrol.MovieRestController;

@SpringBootTest
class MoviedatabaseApplicationTests {

	@Autowired
	private MovieRestController movieRestController;

	@Autowired
	private MovieController movieController;

	@Test
	void contextLoads() {
		Assertions.assertThat(movieRestController).isNotNull();
		Assertions.assertThat(movieController).isNotNull();
	}

}
