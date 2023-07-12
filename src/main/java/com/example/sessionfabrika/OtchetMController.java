package com.example.sessionfabrika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class OtchetMController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private TableColumn<?, ?> clm__id;

    @FXML
    private TableColumn<?, ?> clm_amount;

    @FXML
    private TableColumn<?, ?> clm_name;

    @FXML
    private TableView<Material> table_view;

    @FXML
    private Text txt_qadrat;
    ObservableList<Material> materials = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        materials.addAll(DBUtils.getAllMaterial());
        clm__id.setCellValueFactory(new PropertyValueFactory<>("id"));
        clm_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        clm_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        table_view.setItems(materials);
        table_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Material material = table_view.getSelectionModel().getSelectedItem();
                if(material.getName().toLowerCase().equals("tkan")){
                    txt_qadrat.setText(""+Integer.parseInt(material.getAmount())/4+"m^2");
                }else{
                    txt_qadrat.setText(material.getAmount()+" material");
                }
            }
        });
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"direction.fxml","Director");
            }
        });
    }
}
