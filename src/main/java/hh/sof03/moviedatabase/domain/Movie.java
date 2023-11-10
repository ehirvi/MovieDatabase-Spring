package hh.sof03.moviedatabase.domain;

import java.util.HashSet;
import java.util.Set;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name, description, imgFile;

    private int release_year;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Director director;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    
    @OneToMany(mappedBy = "movie")
    private Set<Watchlist> watchlist;

    
    public Movie() {
    }

    public Movie(String name, String description, String imgFile, int release_year, Director director, Genre genre) {
        this.name = name;
        this.description = description;
        this.imgFile = imgFile;
        this.release_year = release_year;
        this.director = director;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Watchlist> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Set<Watchlist> watchlist) {
        this.watchlist = watchlist;
    }

}