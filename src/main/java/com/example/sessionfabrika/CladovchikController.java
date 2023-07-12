package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CladovchikController implements Initializable {

    @FXML
    private Button btn_infor_about_materials;

    @FXML
    private Button btn_inventerization;

    @FXML
    private AnchorPane info_storage_anchor_pane;

    @FXML
    private Text txt_all_data_about_materials;
    private int click = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_infor_about_materials.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(info_storage_anchor_pane.isVisible()){
                    info_storage_anchor_pane.setVisible(false);
                }else{
                    info_storage_anchor_pane.setVisible(true);
                }
            }
        });
        btn_inventerization.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"inventar.fxml","Inventerization");
            }
        });
    }
}
