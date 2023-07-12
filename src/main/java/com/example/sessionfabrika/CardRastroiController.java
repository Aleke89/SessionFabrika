package com.example.sessionfabrika;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;

public class CardRastroiController implements Initializable {

    @FXML
    private AnchorPane anchor_pane_pechat;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_pechat;

    @FXML
    private ImageView img_fifth;

    @FXML
    private ImageView img_first;

    @FXML
    private ImageView img_fourth;

    @FXML
    private ImageView img_second;

    @FXML
    private ImageView img_sixth;

    @FXML
    private ImageView img_third;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_first.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/first.jpg").toExternalForm()));
        img_second.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/second.jpg").toExternalForm()));
        img_third.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/third.jpg").toExternalForm()));
        img_fourth.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/fourth.jpg").toExternalForm()));
        img_fifth.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/fifth.jpg").toExternalForm()));
        img_sixth.setImage(new Image(getClass().getResource("/com/example/sessionfabrika/sixth.jpg").toExternalForm()));
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"manager.fxml","Manager");
            }
        });
        btn_pechat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                printDocument(anchor_pane_pechat);
            }
        });
    }
    private void printDocument(Node node) {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(node.getScene().getWindow())) {
            PrintRequestAttributeSet printAttributes = new HashPrintRequestAttributeSet();
            printAttributes.add(new PageRanges(1, 1));
            printerJob.getJobSettings().setPageLayout(printerJob.getPrinter().getDefaultPageLayout());
            boolean success = printerJob.printPage(node);
            if (success) {
                printerJob.endJob();
            }
        }
    }
}
