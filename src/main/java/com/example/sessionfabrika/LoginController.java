package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_registration;

    @FXML
    private TextField txf_email;

    @FXML
    private TextField txf_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_registration.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"registration.fxml","Registration");
            }
        });
        btn_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event,txf_email.getText(),txf_password.getText());

            }
        });
    }
}