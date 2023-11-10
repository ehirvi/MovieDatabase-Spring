package hh.sof03.moviedatabase.domain;

import org.springframework.data.repository.CrudRepository;

public interface WatchlistRepository extends CrudRepository<Watchlist, Long> {
    Watchlist findByMovieAndUser(Movie movie, User user);
}
