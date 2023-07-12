package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ZakazchikController implements Initializable {

    @FXML
    private Button btn_constructor;

    @FXML
    private Button btn_list_orders;

    @FXML
    private Button btn_place_an_order;

    @FXML
    private Button btn_production;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_constructor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"constructor.fxml","Constructor");
            }
        });
        btn_list_orders.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"list_order.fxml","List of Orders");
            }
        });
        btn_place_an_order.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"making_order.fxml","Making Order");
            }
        });
    }
}
