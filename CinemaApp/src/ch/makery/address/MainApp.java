package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Movie;
import ch.makery.address.view.MovieOverviewController;
import ch.makery.address.view.PrintTicketButton;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ObservableList<Movie> movieData = FXCollections.observableArrayList();

    public MainApp() {

        movieData.add(new Movie(new SimpleStringProperty("Lord of the rings"), new SimpleStringProperty("January 11, 2002"),
          new SimpleStringProperty("Peter Jackson"), new SimpleDoubleProperty(8.5), new SimpleStringProperty("Today: 12.00"),new SimpleStringProperty("Fran walsh")));
        movieData.add(new Movie(new SimpleStringProperty("Soul"), new SimpleStringProperty("March 12,  2020"),
                new SimpleStringProperty("James Jolis"), new SimpleDoubleProperty(5.3), new SimpleStringProperty("Today: 13.40"),new SimpleStringProperty("Joe denis")));
        movieData.add(new Movie(new SimpleStringProperty("Free Guy"), new SimpleStringProperty("July 1, 2020"),
                new SimpleStringProperty("Shawn Levy"), new SimpleDoubleProperty(6.5), new SimpleStringProperty("Today: 15.00"), new SimpleStringProperty("Ane marris")));
        movieData.add(new Movie(new SimpleStringProperty("The Eternals"), new SimpleStringProperty("November 4, 2020"),
                new SimpleStringProperty("Chloé Zhao"), new SimpleDoubleProperty(7.0), new SimpleStringProperty("Today: 18.00"), new SimpleStringProperty("Merry Doe")));
        movieData.add(new Movie(new SimpleStringProperty("Artemis Fowl"), new SimpleStringProperty("May 29, 2020"),
                new SimpleStringProperty("Kenneth Branagh"), new SimpleDoubleProperty(7.5), new SimpleStringProperty("Today: 20.00"),new SimpleStringProperty("Alice kollin")));
        movieData.add(new Movie(new SimpleStringProperty("The Way Back"), new SimpleStringProperty("March 2020"),
                new SimpleStringProperty("Gavin O'Connor"), new SimpleDoubleProperty(8.0), new SimpleStringProperty("Tomorrow: 14.10"),new SimpleStringProperty("Joe Dan")));
        movieData.add(new Movie(new SimpleStringProperty("Underwater"), new SimpleStringProperty("January 8, 2020"),
                new SimpleStringProperty("William Eubank"), new SimpleDoubleProperty(7.5), new SimpleStringProperty("Tomorrow: 16.00"),new SimpleStringProperty("James bole")));
        movieData.add(new Movie(new SimpleStringProperty("West Side Story"), new SimpleStringProperty("December 16, 2020"),
                new SimpleStringProperty("Steven Spielberg"), new SimpleDoubleProperty(5.0), new SimpleStringProperty("Tomorrow: 17.30"),new SimpleStringProperty("Nikol martinson")));
        movieData.add(new Movie(new SimpleStringProperty("The invisible man"), new SimpleStringProperty("February 4, 2020"),
                new SimpleStringProperty("Leigh Whannell"), new SimpleDoubleProperty(7.8), new SimpleStringProperty("Tomorrow: 19.45"),new SimpleStringProperty("Jason blum")));


    }

    public ObservableList<Movie> getMovieData() {
        return movieData;
    }

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Cinema app");

        initRootLayout();

        showMovieOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout, 700, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showMovieOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MovieOverview.fxml"));
            BorderPane movieOverview = (BorderPane) loader.load();

            rootLayout.setCenter(movieOverview);

            // Give the controller access to the main app.
            MovieOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPrintDialog(Movie movie) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PrintTicketButton.fxml"));
            BorderPane page = (BorderPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Print ticket");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PrintTicketButton controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMovie(movie);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
