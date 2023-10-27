package hh.sof03.moviedatabase.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByDirector(Director director);

    List<Movie> findByName(String name);

    List<Movie> findByGenre(Genre genre);
}
