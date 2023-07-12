module com.example.sessionfabrika {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.sessionfabrika to javafx.fxml;
    exports com.example.sessionfabrika;
}