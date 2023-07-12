package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DirectorController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_otchet_materials;

    @FXML
    private Button btn_otchet_spisaneie;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"login.fxml","Login");
            }
        });
        btn_otchet_spisaneie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"otchetS.fxml","Otchet po spisaniyu");
            }
        });
        btn_otchet_materials.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"otchetM.fxml","Otchet po materials");
            }
        });
    }
}
