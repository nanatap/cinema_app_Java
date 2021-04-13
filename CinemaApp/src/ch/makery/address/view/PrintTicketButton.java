package ch.makery.address.view;

import ch.makery.address.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrintTicketButton {

    @FXML
    private Label movieLabel;
    @FXML
    private Label seatNumberLabel;
    @FXML
    private Label showTimeLabel;

    private Stage dialogStage;
    private Movie movie;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        movieLabel.setText(movie.getTitle());
        seatNumberLabel.setText(String.valueOf((int)(Math.random() * 50)));
        showTimeLabel.setText(movie.getTime());

    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }


}
