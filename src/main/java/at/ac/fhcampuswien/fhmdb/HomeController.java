package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.*;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;


    @FXML
    public JFXListView<Movie> movieListView;

    @FXML
    public JFXComboBox<Genre> genreComboBox;


    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    private final ObservableList<Movie> moviesByGenre = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values());


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here



        //Sort button
        sortBtn.setOnAction(actionEvent -> {
            sortMovies(observableMovies, sortBtn.getText());
            if (Objects.equals(sortBtn.getText(), "Sort (asc)")) {
                sortBtn.setText("Sort (desc)");
            } else {
                sortBtn.setText("Sort (asc)");
            }
        });


        // search button
        searchBtn.setOnAction(actionEvent -> {
            genreFilter(allMovies, genreComboBox.getValue().toString());
            searchRequest(moviesByGenre, searchField.getText().toLowerCase());
            sortMovies(moviesByGenre, sortBtn.getText());

            Genre selectedGenre = genreComboBox.getValue();
            if (selectedGenre != null) {

                if (selectedGenre == Genre.ALL) {
                    observableMovies.clear(); // clear observable list
                    observableMovies.addAll(allMovies); // add all movies to observable list
                } else {
                    // filter observableMovies based on selected genre
                    ObservableList<Movie> filteredMovies = observableMovies.filtered(movie -> movie.getGenres().contains(selectedGenre));
                    movieListView.setItems(filteredMovies);  // update list view with filtered data
                }

            } else {
                // reset list view with all movies when no genre is selected
                movieListView.setItems(observableMovies);
            }
        });


    }


    public List<Movie> genreFilter(List<Movie> allMovies, String genreSelection){
        //clear list before adding the movies
        moviesByGenre.clear();

        for (Movie movies : allMovies) {
            List<Genre> genres = movies.getGenres();

            if (genres.toString().contains(genreSelection)) {
                moviesByGenre.add(movies);
            }
        }
        observableMovies.setAll(moviesByGenre);

        return moviesByGenre;
    }



    public ObservableList<Movie> sortMovies(ObservableList<Movie> observableMovies, String sortBtnText) {

        if (Objects.equals(sortBtnText, "Sort (asc)")) {
            observableMovies.sort(Comparator.comparing(Movie::getTitle));

        } else {
            observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }
        return observableMovies;
    }

    public List<Movie> searchRequest(List<Movie> moviesList, String searchRequest) {
        ObservableList<Movie> movieList = FXCollections.observableArrayList();

        movieList.clear();

        if(searchRequest != " " || searchRequest!=null) {
            for (Movie movie : moviesList) {

                // Check if the movie title or description contain search request
                if (movie.getTitle().toLowerCase().contains(searchRequest) || movie.getDescription().toLowerCase().contains(searchRequest)) {
                    movieList.add(movie);
                }
                observableMovies.setAll(movieList);
            }
        }
        return movieList;
    }


}
