package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOrderController implements Initializable {

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
    private Text txt_all_amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils.getAllOrders(tableView,clm_number,clm_date,clm_finish_date,clm_zakazchik,clm_manager,clm_status);
        txt_all_amount.setText("All amount of orders: " + DBUtils.getAllOrders().size());
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"zakazchik.fxml","Zakazchik");
            }
        });

    }

    public void changeOrder(MouseEvent event) {
        Orders selectedOrder = tableView.getSelectionModel().getSelectedItem();
        if(selectedOrder.getStatus().equals("new")){
            Parent root = null;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(DBUtils.class.getResource("making_order.fxml"));
                root = fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                MakingOrderController makingOrderController = fxmlLoader.getController();
                makingOrderController.setOrderData(selectedOrder,selectedOrder.getNumber(),selectedOrder.getDate(),selectedOrder.getFinish_date(),selectedOrder.getManager());
                stage.setTitle("Changine Order");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
