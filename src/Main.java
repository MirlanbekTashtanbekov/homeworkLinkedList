import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import service.MovieFindableService;
import service.MovieSortableService;
import serviceImpl.MovieFindableServiceImpl;
import serviceImpl.MovieSortableServiceImpl;

import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static database.Database.movies;


public class Main {
    public static void main(String[] args) {

        Producer producer1 = new Producer("Suimonkul", "Chokmporov");
        Producer producer2 = new Producer("Dolon", "Omurzakov");
        Producer producer3 = new Producer("Joldubai", "Kaipov");

        java.util.List<Actor> actors1 = Arrays.asList(
                new Actor("Christofer Robin", "Halk"),
                new Actor("Robert Downey", "Iron men"),
                new Actor("Julia Roberts", "Ruatenaway bride")       );

        List<Actor> actors2 = Arrays.asList(
                new Actor("Adam Sendler", "Clik"),
                new Actor("Tom Nolan", "Spider-men"),
                new Actor("Jhony Depp", "Captain Vorobei")
        );
        List<Actor> actors3 = Arrays.asList(
                new Actor("Jeki Chan", "Kung Fu"),
                new Actor("Bruce Li", "Master Kar"),
                new Actor("Chang li", "Master Kung Fu")
        );

        movies.add(new models.Movie("Spider-men", LocalDate.of(2010, 1, 1), Genre.COMEDY, producer1, actors1));
        movies.add(new models.Movie("Iron men", LocalDate.of(2018, 5, 1), Genre.HORROR, producer2, actors2));
        movies.add(new Movie("Captain Vorobei",LocalDate.of(2020,2,1),Genre.DRAMA,producer3,actors3));


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choice number: ");
            System.out.println("1. Find movie: ");
            System.out.println("2. Sort movie: ");
            System.out.println("3. Get all movie");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Write name movie: ");
                    String name = scanner.next();
                    MovieFindableService findableService = null;
                    Movie movie = findableService.findMovieByFullNameOrPartName(name);
                    System.out.println(movie != null ? movie : "Error");
                }
                case 2 -> {
                    System.out.println("1. Sort by name from A to Z ");
                    System.out.println("2. Sort by year ");
                    int sortChoice = scanner.nextInt();
                    MovieSortableService sortableService = null;
                    if (sortChoice == 1) {
                        System.out.println("from A to Z :");
                        //String order = scanner.next();
                        new MovieSortableService() {
                            @Override
                            public void sortMovieByName(String ascOrDesc) {

                            }

                            @Override
                            public void sortByYear(String ascOrDesc) {

                            }

                            @Override
                            public void sortByProducer(String nameOrLastName) {

                            }
                        }.sortMovieByName(movies.toString());
                        //sortableService.sortMovieByName(order);
                    } else if (sortChoice == 2) {
                        System.out.println("from Z to A :");
                        String order = scanner.next();
                        sortableService.sortByYear(order);
                    }
                    System.out.println("Successfully!");
                }
                case 3 -> Database.getAllMovies().forEach((Consumer<? super Movie>) movies);
                case 4 -> {
                    System.out.println("EXIT");
                    return;
                }
                default -> System.out.println("ERROR");
            }
        }
    }
}

