package com.example.sessionfabrika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MakingOrderController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_make_order;

    @FXML
    private ChoiceBox<String> chc_furniture;

    @FXML
    private ChoiceBox<String> chc_material;

    @FXML
    private TextField txf_date;

    @FXML
    private TextField txf_finish_date;

    @FXML
    private TextField txf_name_of_order;
    @FXML
    private ChoiceBox<String> chc_manager;
    public Orders orders;
    ObservableList<String> tkani = FXCollections.observableArrayList();
    ObservableList<String> managers = FXCollections.observableArrayList();
    ObservableList<String> furnitura = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tkani.add("tkan1");
        tkani.add("tkan2");
        tkani.add("tkan3");
        tkani.add("tkan4");
        managers.add("Manager Jack");
        managers.add("Manager Kei");
        managers.add("Manager Jax");
        managers.add("Manager Someone");
        furnitura.add("furnitura1");
        furnitura.add("furnitura2");
        furnitura.add("furnitura3");
        furnitura.add("furnitura4");
        chc_manager.setItems(managers);
        chc_furniture.setItems(furnitura);
        chc_material.setItems(tkani);
        btn_make_order.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.makeOrder(orders,event,txf_name_of_order.getText(),txf_date.getText(),txf_finish_date.getText(),DBUtils.nameOfZakazchik,chc_manager.getValue());
            }
        });
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"zakazchik.fxml","Zakazchik");
            }
        });
    }
    public void setOrderData(Orders orderData,String number,String date,String finishDate,String manager){
        orders = orderData;
        txf_date.setText(date);
        txf_finish_date.setText(finishDate);
        txf_name_of_order.setText(number);
        chc_manager.setValue(manager);
    }
}
