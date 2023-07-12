package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ZatratController implements Initializable {

    @FXML
    private FlowPane anchor_pane;

    @FXML
    private Button btn_back;

    @FXML
    private TableColumn<?, ?> clm_id;

    @FXML
    private TableColumn<?, ?> clm_shirina;

    @FXML
    private TableColumn<?, ?> clm_vysota;

    @FXML
    private TableView<Zakaz> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils.getAllZakaz(tableView, clm_id, clm_vysota, clm_shirina);
        anchor_pane.setPadding(new Insets(10));
        anchor_pane.setHgap(10);
        anchor_pane.setVgap(10);
        anchor_pane.setAlignment(Pos.TOP_RIGHT);
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"manager.fxml","Manager");
            }
        });
    }

    public void onMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) { // Обработка двойного щелчка
            Zakaz selectedItem = tableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                createPane(Double.parseDouble(selectedItem.getShirina()), Double.parseDouble(selectedItem.getVysota()));
            }}
//        } else if(event.getClickCount()==1){
//            if (tableView.getSelectionModel().isSelected(tableView.getItems().size() - 1)) {
//                addAllPanesToFlowPane();
//            }
//        }
    }

    private void addAllPanesToFlowPane() {
        for (Zakaz item : tableView.getItems()) {
            createPane(Double.parseDouble(item.getShirina()), Double.parseDouble(item.getVysota()));
        }
    }

    private void createPane(double width, double height) {
        // Удаление предыдущего Pane (если есть)
        Pane pane = new Pane();
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setStyle("-fx-background-color: lightblue;");
        anchor_pane.getChildren().add(0,pane);
    }
    private void adjustFlowPaneWidth() {
        double totalWidth = anchor_pane.getChildren().stream()
                .mapToDouble(node -> ((Pane) node).getPrefWidth())
                .sum();
        anchor_pane.setPrefWidth(totalWidth + anchor_pane.getHgap() * (anchor_pane.getChildren().size() - 1));
    }
}
