package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {

        authSignInButton.setOnAction(event -> {
            String loginText = login_field.getText().trim(); //получаем текст из текстового поля логин
            String loginPassword = password_field.getText().trim(); //получаем текст из текстового поля пароль

            if (!loginText.equals("")&& !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and Password is empty");
        });


        loginSignUpButton.setOnAction(event -> {
            openNewScene("/sample/siginUp.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHamdler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHamdler.getUser(user);
        int counter = 0;
        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter>=1){

            openNewScene("/sample/app.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPasswordAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
        }
    }

    public void openNewScene(String window){
        loginSignUpButton.getScene().getWindow().hide();// берём эту сцену, берём это окно и прячем его

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));//отображаем нужное нам окно

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
    }


}
