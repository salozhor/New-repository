package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView imageButtonUser;

    @FXML
    void initialize(ScrollEvent event) {

    }

    @FXML
    void initialize() {
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'app.fxml'.";
        assert imageButtonUser != null : "fx:id=\"imageButtonUser\" was not injected: check your FXML file 'app.fxml'.";

    }
}
