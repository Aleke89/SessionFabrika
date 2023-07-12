package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_ocenka_furnitura;

    @FXML
    private Button btn_ocenka_zatrat;

    @FXML
    private Button btn_rackroi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_ocenka_zatrat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"zatrat.fxml","Оценка затрат");
            }
        });
        btn_rackroi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"card_rastroi.fxml","Card Rastroi");
            }
        });
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"login.fxml","Login");
            }
        });
        btn_ocenka_furnitura.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"zatrat_furniture.fxml","Zatraty Furniture");
            }
        });
    }
}
