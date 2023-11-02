package hh.sof03.moviedatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDirector() {
        return director.getName();
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getGenre() {
        return genre.getName();
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}