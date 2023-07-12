package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarController implements Initializable {

    @FXML
    private Button btn_setData;

    @FXML
    private Text txt_percentage_getting_out;

    @FXML
    private Text txt_price_from_db;

    @FXML
    private Text txt_price_from_db1;
    @FXML
    private Button btn_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_setData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt_price_from_db.setVisible(true);
                txt_percentage_getting_out.setVisible(true);
                txt_percentage_getting_out.setText("5%");
            }
        });
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"kladovchik.fxml","Kladovchik");
            }
        });
    }
}
