package com.example.sessionfabrika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.transform.dom.DOMResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
    private static Connection connection;
    public static String nameOfZakazchik = "";

    public static void changeScene(ActionEvent event, String fxml, String title) {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(DBUtils.class.getResource(fxml));
            root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeZakaz(String vysota, String shirina) {
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        try {
            connection1 = getConnect();
            preparedStatement = connection1.prepareStatement("INSERT INTO `order` (`vysota`, `shirina`) VALUES (?, ?);");
            preparedStatement.setString(1, vysota);
            preparedStatement.setString(2, shirina);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllZakaz(TableView<Zakaz> tableView, TableColumn clm_id, TableColumn clm_vysota, TableColumn clm_shirina) {
        ObservableList<Zakaz> zakazObservableList = FXCollections.observableArrayList();
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection1 = getConnect();
            preparedStatement = connection1.prepareStatement("SELECT * FROM fabrika.order");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                zakazObservableList.add(new Zakaz(resultSet.getInt("id"),
                        resultSet.getString("vysota"),
                        resultSet.getString("shirina")));
            }
            clm_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            clm_vysota.setCellValueFactory(new PropertyValueFactory<>("vysota"));
            clm_shirina.setCellValueFactory(new PropertyValueFactory<>("shirina"));
            tableView.setItems(zakazObservableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabrika", "root", "ernur2007");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void getAllOrders(TableView<Orders> tableView, TableColumn clm_number, TableColumn clm_date, TableColumn clm_finish_date, TableColumn clm_zakazchik, TableColumn clm_manager, TableColumn clm_status) {
        ObservableList<Orders> ordersObservableList = FXCollections.observableArrayList();
        try {
            Connection connection1 = getConnect();
            PreparedStatement preparedStatement = connection1.prepareStatement("SELECT * FROM zakaz");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ordersObservableList.add(new Orders(resultSet.getInt("id"), resultSet.getString("number"),
                        resultSet.getString("date"),
                        resultSet.getString("finish_date"),
                        resultSet.getString("zakazchik"),
                        resultSet.getString("manager"),
                        resultSet.getString("status"),
                        resultSet.getString("furniture"),
                        resultSet.getString("tkan"),
                        resultSet.getString("okontovka")));
            }
            clm_number.setCellValueFactory(new PropertyValueFactory<>("number"));
            clm_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            clm_finish_date.setCellValueFactory(new PropertyValueFactory<>("finish_date"));
            clm_zakazchik.setCellValueFactory(new PropertyValueFactory<>("zakazchik"));
            clm_manager.setCellValueFactory(new PropertyValueFactory<>("manager"));
            clm_status.setCellValueFactory(new PropertyValueFactory<>("status"));
            tableView.setItems(ordersObservableList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void makeOrder(Orders orders, ActionEvent event, String nameOfOrder, String date, String finishDate, String zakazchik, String manager) {
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementUpdate = null;
        PreparedStatement checkPrepareStatement = null;
        ResultSet resultSet = null;
        try {
            connection1 = getConnect();
            preparedStatement = connection1.prepareStatement("INSERT INTO zakaz (number, date, finish_date, zakazchik, manager, status) VALUES (?,?,?,?,?,?);");
            checkPrepareStatement = connection1.prepareStatement("SELECT * FROM zakaz WHERE number = ?");
            checkPrepareStatement.setString(1, nameOfOrder);
            resultSet = checkPrepareStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                preparedStatementUpdate = connection1.prepareStatement("UPDATE `zakaz` SET `number` = '" + nameOfOrder + "', `date` = '" + date + "', `finish_date` = '" + finishDate + "', `zakazchik` = '" + zakazchik + "', `manager` = '" + manager + "', `status` = 'new' WHERE (`id` = '" + orders.getId() + "');");
                preparedStatementUpdate.executeUpdate();
            } else {
                preparedStatement.setString(1, nameOfOrder);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, finishDate);
                preparedStatement.setString(4, zakazchik);
                preparedStatement.setString(5, manager);
                preparedStatement.setString(6, "new");
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<Orders> getAllOrders() {
        ObservableList<Orders> ordersObservableList = FXCollections.observableArrayList();
        try {
            Connection connection1 = getConnect();
            PreparedStatement preparedStatement = connection1.prepareStatement("SELECT * FROM zakaz");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ordersObservableList.add(new Orders(resultSet.getInt("id"), resultSet.getString("number"),
                        resultSet.getString("date"),
                        resultSet.getString("finish_date"),
                        resultSet.getString("zakazchik"),
                        resultSet.getString("manager"),
                        resultSet.getString("status"),
                        resultSet.getString("furniture"),
                        resultSet.getString("tkan"),
                        resultSet.getString("okontovka")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersObservableList;
    }

    public static void getAllMaterial(TableView<Material> tableView, TableColumn clm_id, TableColumn clm_name, TableColumn clm_amount, TableColumn clm_cause) {
        ObservableList<Material> materialsObservableList = FXCollections.observableArrayList();
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection1 = getConnect();
            preparedStatement = connection1.prepareStatement("SELECT * FROM fabrika.material;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                materialsObservableList.add(new Material(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("amount"),
                        resultSet.getString("cause")
                ));
            }
            clm_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            clm_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            clm_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            clm_cause.setCellValueFactory(new PropertyValueFactory<>("cause"));
            tableView.setItems(materialsObservableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<Material> getAllMaterial() {
        ObservableList<Material> materialsObservableList = FXCollections.observableArrayList();
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection1 = getConnect();
            preparedStatement = connection1.prepareStatement("SELECT * FROM fabrika.material;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                materialsObservableList.add(new Material(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("amount"),
                        resultSet.getString("cause")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return materialsObservableList;
    }
    public static void logInUser(ActionEvent event, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnect();
            preparedStatement = connection.prepareStatement("SELECT email,password,zakazchik,manager,kladovchik,direction FROM user WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User not found or incorrect values");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retPassword = resultSet.getString("password");
                    Boolean zakazchik = resultSet.getBoolean("zakazchik");
                    Boolean manager = resultSet.getBoolean("manager");
                    Boolean kladovchik = resultSet.getBoolean("kladovchik");
                    Boolean direction = resultSet.getBoolean("direction");
                    nameOfZakazchik = email;
                    if (retPassword.equals(password)) {
                        if (zakazchik) {
                            changeScene(event, "zakazchik.fxml", "Zakazchik");
                        } else if (manager) {
                            changeScene(event, "manager.fxml", "Manager");
                        } else if (kladovchik) {
                            changeScene(event, "kladovchik.fxml", "Kladovchik");
                        } else if (direction) {
                            changeScene(event, "direction.fxml", "Director");
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password incorrect!");
                        alert.show();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registration(ActionEvent event, String email, String password, String role) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement checkStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnect();
            checkStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
            checkStatement.setString(1, email);
            resultSet = checkStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Already Exists with this email");
                alert.show();
            } else {
                preparedStatement = connection.prepareStatement("INSERT INTO user (email, password, zakazchik, manager, kladovchik, direction) VALUES (?,?,?,?,?,?);");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                if (role.toLowerCase().equals("zakazchik")) {
                    preparedStatement.setBoolean(3, true);
                    preparedStatement.setBoolean(4, false);
                    preparedStatement.setBoolean(5, false);
                    preparedStatement.setBoolean(6, false);
                    preparedStatement.executeUpdate();
                } else if (role.toLowerCase().equals("manager")) {
                    preparedStatement.setBoolean(3, false);
                    preparedStatement.setBoolean(4, true);
                    preparedStatement.setBoolean(5, false);
                    preparedStatement.setBoolean(6, false);
                    preparedStatement.executeUpdate();
                } else if (role.toLowerCase().equals("kladovchik")) {
                    preparedStatement.setBoolean(3, false);
                    preparedStatement.setBoolean(4, false);
                    preparedStatement.setBoolean(5, true);
                    preparedStatement.setBoolean(6, false);
                    preparedStatement.executeUpdate();
                } else if (role.toLowerCase().equals("director")) {
                    preparedStatement.setBoolean(3, false);
                    preparedStatement.setBoolean(4, false);
                    preparedStatement.setBoolean(5, false);
                    preparedStatement.setBoolean(6, true);
                    preparedStatement.executeUpdate();
                }
                changeScene(event, "login.fxml", "Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
