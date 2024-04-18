package ru.mixail.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.mixail.app.ConnectBD;
import ru.mixail.essense.Street;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetEditorController {


    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private TextField streetNameField;

    @FXML
    private TableView<Street> streetsTable;

    @FXML
    private TableColumn<Street, String> streetNameColumn;


    @FXML
    private void addStreet() {
        String streetName = streetNameField.getText();
        if (!streetName.isEmpty()) {
            Street street = new Street(streetName);
            insertStreet(street);
        }
    }

    private void insertStreet(Street street) {
        String sql = "INSERT INTO Street (name) VALUES (?)";
        try (Connection connection = ConnectBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, street.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editStreet() {
        // Метод для редактирования улицы
    }

    @FXML
    public void deleteStreet() {
        // Метод для удаления улицы
    }
}