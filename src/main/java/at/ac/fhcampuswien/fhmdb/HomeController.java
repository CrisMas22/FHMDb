package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView <Movie> movieListView;

    @FXML
    public JFXComboBox <Genre> genreComboBox;


    @FXML
    public JFXButton sortBtn;


    public List<Movie> allMovies = Movie.initializeMovies();

    final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    public SortState sortState = SortState.NONE;

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

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
                observableMovies.sort(Comparator.comparing(Movie::getTitle));
            } else {
                // TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
                observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            }

        });

    }
    public void initializeState(){      //from here until the end I don't have it
        observableMovies.clear();
        observableMovies.addAll(allMovies);
    }

    public void sortMovies(){
        observableMovies.sort(Comparator.comparing(Movie::getTitle));
        sortState = SortState.ASCENDING;
    }



   /*     searchBtn.setOnAction(actionEvent -> {
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
        });*/
       // searchBtn.setOnAction(actionEvent -> {
         //   Genre selectedGenre = genreComboBox.getValue();

            //if (selectedGenre == Genre.NO_FILTER) {
                //ObservableList<Movie>  = observableMovies.filtered(movie -> movie.getGenres().contains(allMovies));
               // movieListView.setItems(filteredMovies);  // update list view with filtered data
               // observableMovies.clear(); // clear observable list
               // observableMovies.addAll(allMovies); // add all movies to observable list
           // }
           // else if (selectedGenre == null || searchBtn== null){
               // observableMovies.addAll(allMovies); // add all movies to observable list
            //}



     //   });


        // Filter button
        searchBtn.setOnAction(actionEvent -> {
            searchField.setText("Search");

            String searchTerm = searchField.getText().toLowerCase();
            // convert search term to lower case for case-insensitive search

            if(genreComboBox.getSelectionModel().getSelectedItem() == null || genreComboBox.getSelectionModel().getSelectedItem() == Genre.ALL) {
                // no genre filter selected
                if(searchTerm.isEmpty()) {
                    // no search term entered
                    observableMovies.clear(); // clear observable list
                    observableMovies.addAll(allMovies); // add all movies to observable list
                } else {
                    // search term entered
                    observableMovies.clear(); // clear observable list
                    List<String> movieNames = new ArrayList<String>() ;
                    for(Movie movie : allMovies) {
                        if(movie.getTitle().toLowerCase().contains(searchTerm) || movie.getDescription().toLowerCase().contains(searchTerm)) {
                            String movieName = movie.getTitle();
                            if (!movieNames.contains(movieName)) {
                                movieNames.add(movieName);
                                observableMovies.add(movie);
                                // remove duplicate movies
                            }
                        }
                    }
                }
            } else {
                // genre filter selected
                Genre selectedGenre = genreComboBox.getSelectionModel().getSelectedItem();

                if(searchTerm.isEmpty()) {
                    // no search term entered
                    observableMovies.clear(); // clear observable list
                    for(Movie movie : allMovies) {
                        if(movie.getGenres().contains(selectedGenre)) {
                            observableMovies.add(movie); // add movie to observable list if it contains the selected genre
                        }
                    }

                } else {
                    // search term entered
                    observableMovies.clear(); // clear observable list

                    List<String> movieNames = new ArrayList<String>() ;
                    for(Movie movie : allMovies) {
                        if (movie.getGenres().contains(selectedGenre) && (movie.getTitle().toLowerCase().contains(searchTerm) || movie.getDescription().toLowerCase().contains(searchTerm)))  {
                            String movieName = movie.getTitle();
                            if (!movieNames.contains(movieName)) {
                                movieNames.add(movieName);
                                observableMovies.add(movie);
                                // remove duplicate movies
                            }
                        }
                    }

                }
            }
        };









    }
