package com.example.sessionfabrika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ConstructorController implements Initializable {

    @FXML
    private ChoiceBox<String> chc_furnitura;

    @FXML
    private ChoiceBox<String> chc_ocontovka;

    @FXML
    private ChoiceBox<String> chc_tkan;

    @FXML
    private TextField txf_razmer;

    @FXML
    private TextField txf_shirina;

    @FXML
    private TextField txf_svoi_variant;

    @FXML
    private TextField txf_vysota;
    @FXML
    private Button btn_svoi_variant;
    @FXML
    private Button btn_finish;
    @FXML
    private VBox Vbox;

    ObservableList<String> tkani = FXCollections.observableArrayList();
    ObservableList<String> okontovka = FXCollections.observableArrayList();
    ObservableList<String> furnitura = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tkani.add("tkan1");
        tkani.add("tkan2");
        tkani.add("tkan3");
        tkani.add("tkan4");
        okontovka.add("okontovka1");
        okontovka.add("okontovka2");
        okontovka.add("okontovka3");
        okontovka.add("okontovka4");
        furnitura.add("furnitura1");
        furnitura.add("furnitura2");
        furnitura.add("furnitura3");
        furnitura.add("furnitura4");
        chc_furnitura.setItems(furnitura);
        chc_ocontovka.setItems(okontovka);
        chc_tkan.setItems(tkani);
        btn_svoi_variant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(new Stage());
                if (selectedFile != null) {
                    // Устанавливаем путь выбранного файла в TextField
                    txf_svoi_variant.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        btn_finish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.makeZakaz(txf_vysota.getText(),txf_shirina.getText());
                DBUtils.changeScene(event,"zakazchik.fxml","Zakazchik");
            }
        });
        Vbox.setOnDragOver(createDragOverEventHandler());
        Vbox.setOnDragDropped(createDragDroppedEventHandler());
    }
    private EventHandler<DragEvent> createDragOverEventHandler() {
        return event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        };
    }

    private EventHandler<DragEvent> createDragDroppedEventHandler() {
        return event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.hasFiles()) {
                List<File> files = dragboard.getFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        Image image = new Image(file.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(234);
                        imageView.setFitHeight(259);
                        Vbox.getChildren().add(imageView);
                    }
                }
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }
            event.consume();
        };
    }
}
