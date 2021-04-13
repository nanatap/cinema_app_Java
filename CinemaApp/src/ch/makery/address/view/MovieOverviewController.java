package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

    public class MovieOverviewController {
        @FXML
        private TableView<Movie> movieTable;
        @FXML
        private TableColumn<Movie, String> titleColumn;
        @FXML
        private TableColumn<Movie, String> timeColumn;

        @FXML
        private Label titleLabel;
        @FXML
        private Label directorLabel;
        @FXML
        private Label producerLabel;
        @FXML
        private Label releaseDateLabel;
        @FXML
        private Label priceLabel;

        private MainApp mainApp;

        public MovieOverviewController() {
        }


        @FXML
        private void initialize() {
            titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
            timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());


            showMovieDetails(null);

            movieTable.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showMovieDetails(newValue));
        }

        public void setMainApp(MainApp mainApp) {
            this.mainApp = mainApp;

            movieTable.setItems(mainApp.getMovieData());
        }

        private void showMovieDetails(Movie movie) {
            if (movie != null) {
                titleLabel.setText(movie.getTitle());
                releaseDateLabel.setText(movie.getReleaseDate());
                directorLabel.setText(movie.getDirector());
                priceLabel.setText(Double.toString(movie.getTicketPrice()));
                producerLabel.setText(movie.getProducer());

            } else {
                titleLabel.setText("");
                releaseDateLabel.setText("");
                directorLabel.setText("");
                priceLabel.setText("");
                producerLabel.setText("");

            }
        }

        private void initializeMovie() {
            titleColumn.setCellValueFactory(
                    cellData -> cellData.getValue().titleProperty());
            timeColumn.setCellValueFactory(
                    cellData -> cellData.getValue().timeProperty());

            showMovieDetails(null);

            movieTable.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showMovieDetails(newValue));
        }

        @FXML
        private void handlePrint() {

            Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();

            if (selectedMovie != null) {
                mainApp.showPrintDialog(selectedMovie);
            } else {
                System.out.println("Movie not selected");
            }

        }
    }
