package serviceImpl;


import database.Database;
import models.Movie;
import service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;

import static database.Database.movies;

public class MovieSortableServiceImpl implements MovieSortableService {


    @Override
    public void sortMovieByName(String ascOrDesc) {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getName);
        if (ascOrDesc.equalsIgnoreCase("Desc")) {
            comparator = comparator.reversed();
        }
        Database.getAllMovies().sort(comparator);

    }

    @Override
    public void sortByYear(String ascOrDesc) {
        movies.sort(ascOrDesc.equalsIgnoreCase("Desc") ?
                Comparator.comparing(Movie::getYear) :
                Comparator.comparing(Movie::getYear).reversed());

    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        Comparator<Movie> comparator = Comparator.comparing(
                movie -> movie.getProducer().getFullName()
        );
        Database.getAllMovies().sort(comparator);
    }


}
