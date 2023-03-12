package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    // testing if the movies and genres match correctly
    void just_the_matching_movies_and_Genre_are_shown(){
        // GIVEN

        HomeController homeController = new HomeController();
        List <Movie> movieList = new ArrayList<>();
        List<Movie> movieList1;

        Movie movie1 = new Movie("Movie 1", "description1", List.of(Genre.ADVENTURE));
        Movie movie2 = new Movie("Movie 2", "description2", List.of(Genre.DRAMA));
        Movie movie3 = new Movie("Movie 3", "description3", List.of(Genre.DRAMA));
        Movie movie4 = new Movie("Movie 4", "description3", List.of(Genre.CRIME));
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);

        // WHEN
        movieList1 = homeController.genreFilter(movieList, "DRAMA");


        // THEN
        //List contains the movies that have been searched
        List<Movie> requestedMovie = new ArrayList<>();
        requestedMovie.add(movie2);
        requestedMovie.add(movie3);

        assertEquals(requestedMovie, movieList1);

    }
    @Test
    //testing if the search function shows the correct results
    void just_movies_are_shown_that_have_the_words_that_are_searched(){

        // GIVEN
        HomeController homeController = new HomeController();
        List <Movie> movieArrayList = new ArrayList<>();
        List<Movie> currentMovieList;

        Movie movie1 = new Movie("Movie 1", "description1", List.of(Genre.MUSICAL));
        Movie movie2 = new Movie("Movie 2", "description32", List.of(Genre.MYSTERY));
        Movie movie3 = new Movie("Movie 3", "description3", List.of(Genre.DOCUMENTARY));
        movieArrayList.add(movie1);
        movieArrayList.add(movie2);
        movieArrayList.add(movie3);


        // WHEN
        currentMovieList = homeController.searchRequest(movieArrayList, "description3");


        // THEN

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie2);
        expectedMovies.add(movie3);

        assertEquals(expectedMovies, currentMovieList);
    }
    @Test
    void when_sortButton_asc_movie_list_sorted_des(){
        // GIVEN
        HomeController homeController = new HomeController();


        ObservableList<Movie> observableList = FXCollections.observableArrayList();
        Movie movie1 = new Movie("a-Movie1", "description1", List.of(Genre.WAR));
        Movie movie2 = new Movie("c-Movie2", "description2", List.of(Genre.BIOGRAPHY));
        Movie movie3 = new Movie("b-Movie3", "description3", List.of(Genre.ADVENTURE));
        observableList.add(movie1);
        observableList.add(movie2);
        observableList.add(movie3);

        // WHEN
        ObservableList<Movie> current = homeController.sortMovies(observableList, "Sort (desc)"); //current

        // THEN

        ObservableList<Movie> anticipatedMovies = FXCollections.observableArrayList();
        anticipatedMovies.add(movie2);
        anticipatedMovies.add(movie3);
        anticipatedMovies.add(movie1);
        //test
        assertEquals(anticipatedMovies, current);
    }
}