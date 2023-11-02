package hh.sof03.moviedatabase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;

@DataJpaTest
public class MovieRepositoryTest {
    
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void createNewMovie() {
        Movie movie = new Movie("Star Wars", "desc", "img", 1977 , null, null);
        movieRepository.save(movie);
        Assertions.assertThat(movie.getId()).isNotNull();
    }

}
