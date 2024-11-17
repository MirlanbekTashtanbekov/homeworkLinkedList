package service;

public interface MovieSortableService {
    void sortMovieByName(String ascOrDesc);

//-from A to Z

//-from Z to A

    void sortByYear(String ascOrDesc);

//-Ascending

//-Descending

    void sortByProducer(String nameOrLastName);
}
