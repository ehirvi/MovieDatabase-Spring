package hh.sof03.moviedatabase.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WatchlistKey implements Serializable {
    
    @Column(name = "user_id")
    Long userId;

    @Column(name = "movie_id")
    Long movieId;

}
