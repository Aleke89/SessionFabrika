package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class OtchetSController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private TableColumn<?, ?> clm_amount;

    @FXML
    private TableColumn<?, ?> clm_cause;

    @FXML
    private TableColumn<?, ?> clm_id;

    @FXML
    private TableColumn<?, ?> clm_name;

    @FXML
    private TableView<Material> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"direction.fxml","Director");
            }
        });
        DBUtils.getAllMaterial(tableView,clm_id,clm_name,clm_amount,clm_cause);
    }
}
