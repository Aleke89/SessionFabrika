package com.example.sessionfabrika;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ZatratFurnitureController implements Initializable {

    @FXML
    private Button btn_back;

    @FXML
    private TableColumn<?, ?> clm_date;

    @FXML
    private TableColumn<?, ?> clm_finish_date;

    @FXML
    private TableColumn<?, ?> clm_manager;

    @FXML
    private TableColumn<?, ?> clm_number;

    @FXML
    private TableColumn<?, ?> clm_status;

    @FXML
    private TableColumn<?, ?> clm_zakazchik;

    @FXML
    private TableView<Orders> tableView;

    @FXML
    private Text txt_furniture_amount;

    @FXML
    void changeOrder(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils.getAllOrders(tableView,clm_number,clm_date,clm_finish_date,clm_zakazchik,clm_manager,clm_status);
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Orders orders = tableView.getSelectionModel().getSelectedItem();
                Random random = new Random();
                int min = 10;
                int max = 50;
                int randomNumber = random.nextInt(max - min + 1) + min;
                int randomCheckNumber = random.nextInt(2);
                if(randomCheckNumber==0){
                    txt_furniture_amount.setText("Не хватает "+orders.getFurniture()+" для изготовления "+randomNumber+" текстильных изделий в складе!");
                }else{
                    txt_furniture_amount.setText("Хватает "+orders.getFurniture()+" для изготовления "+randomNumber+" текстильных изделий в складе!");
                }
            }
        });
    }
}
