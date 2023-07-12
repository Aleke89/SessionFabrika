package com.example.sessionfabrika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_registration;

    @FXML
    private ChoiceBox<String> chc_role;

    @FXML
    private TextField txf_email;

    @FXML
    private TextField txf_password;
    ObservableList<String> roles = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roles.add("Manager");
        roles.add("Kladovchik");
        roles.add("Director");
        roles.add("Zakazchik");
        chc_role.setItems(roles);
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"login.fxml","Login");
            }
        });
        btn_registration.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.registration(event,txf_email.getText(),txf_password.getText(),chc_role.getValue());
            }
        });
    }
}