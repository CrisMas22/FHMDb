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
    public void test_All_Movies_Shown_Without_Filter() {

        HomeController homeController = new HomeController();
        List <Movie> movieList = new ArrayList<>();
        List<Movie> movieList1;

        // Given
        Movie movie1 = new Movie("Movie 1", "description1", List.of(Genre.ADVENTURE));
        Movie movie2 = new Movie("Movie 2", "description2", List.of(Genre.DRAMA));
        Movie movie3 = new Movie("Movie 3", "description3", List.of(Genre.DRAMA));
        Movie movie4 = new Movie("Movie 4", "description3", List.of(Genre.CRIME));
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);


        // When
        movieList1 = homeController.genreFilter(movieList, "ALL");

        // Then
        List<Movie> allMovies = Movie.initializeMovies();
        assertTrue(allMovies.containsAll(allMovies));


    }
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
    // testing if the sort button can sort the movies ascending
    void when_sort_button_desc_movie_list_sorted_asc(){
        // GIVEN
        HomeController homeController = new HomeController();

        ObservableList<Movie> exampleMovies = FXCollections.observableArrayList();
        Movie movie1 = new Movie("a-Movie1", "description1", List.of(Genre.DOCUMENTARY));
        Movie movie2 = new Movie("c-Movie2", "description2", List.of(Genre.SCIENCE_FICTION));
        Movie movie3 = new Movie("b-Movie3", "description3", List.of(Genre.WESTERN));
        exampleMovies.add(movie1);
        exampleMovies.add(movie2);
        exampleMovies.add(movie3);

        // WHEN
        ObservableList<Movie> actual = homeController.sortMovies(exampleMovies, "Sort (asc)");

        // THEN

        ObservableList<Movie> expected = FXCollections.observableArrayList();
        expected.add(movie1);
        expected.add(movie3);
        expected.add(movie2);
        //test
        assertEquals(expected, actual);
    }
    @Test
    //testing if the sort button can dort the movies descebding
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
    @Test
    //testing if the filter function can show the correct results base on genre
    void show_corresponding_movies_when_genreFilter_and_searchRequest_used(){
        // GIVEN
        HomeController homeController = new HomeController();
        List <Movie> movieList = new ArrayList<>();
        List<Movie> movieList1;
        List<Movie> movieList2;

        Movie movie1 = new Movie("Movie 1", "description1", List.of(Genre.COMEDY));
        Movie movie2 = new Movie("Movie 2", "description2", List.of(Genre.ADVENTURE));
        Movie movie3 = new Movie("Movie 3", "description3", List.of(Genre.SPORT));
        Movie movie4 = new Movie("Movie 4", "description4", List.of(Genre.DRAMA));

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);

        // WHEN
        movieList1 = homeController.searchRequest(movieList, "description3");
        movieList2 = homeController.genreFilter(movieList1, "SPORT");


        // THEN
        List<Movie> CMovies = new ArrayList<>();
        CMovies.add(movie3);

        assertEquals(CMovies, movieList2);
    }
}