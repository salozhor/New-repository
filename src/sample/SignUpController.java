package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPassword1;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField signUpPassword2;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            SignUpNewUesr();

            signUpButton.getScene().getWindow().hide();// берём эту сцену, берём это окно и прячем его

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));//отображаем нужное нам окно

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //загрузка файла для дальнейшего отображения

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

    private void SignUpNewUesr() {
        if (signUpPassword1.getText().trim().equals(signUpPassword2.getText().trim())){

                DatabaseHandler dbHandler = new DatabaseHandler();
                String login = signUpLogin.getText();
                String password = signUpPassword1.getText();

                User user = new User(login, password, 0, 0);
                dbHandler.siginUpUser(user);

        }
    }
}
