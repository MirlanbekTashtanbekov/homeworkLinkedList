package serviceImpl;

import database.Database;
import enums.Genre;
import models.Movie;
import models.Producer;
import service.MovieFindableService;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static database.Database.movies;

public class MovieFindableServiceImpl implements MovieFindableService {


    @Override
    public List<Movie> getAllMovies() {
        return getAllMovies(movies);
    }

    private List<Movie> getAllMovies(List<Movie> movies) {
        return getAllMovies();
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie: movies){
            if (Objects.equals(movie.getName(), name)){
                return movie;
            }
        }
        return findMovieByFullNameOrPartName(name);
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie: movies){
            if(Objects.equals(movie.getActors(), actorName)){
                return movie;
            }
        }
        return findMovieByActorName(actorName);
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie: movies){
            if (movie.getYear()==year){
                return movie;
            }
        }
        return findMovieByYear(year);
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        return movies.stream()
                .filter(movie -> movie.getProducer().getFullName().equalsIgnoreCase(producerFullName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre() == genre)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByRole(String role) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getRole().equalsIgnoreCase(role)))
                .findFirst()
                .orElse(null);
    }
}
