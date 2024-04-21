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
    private TextField streetNameField;

    @FXML
    private TableView<Street> streetsTable;

    @FXML
    private TableColumn<Street, String> streetNameColumn;

    @FXML
    private void initialize() {
        streetNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        loadStreets();
    }

    @FXML
    private void addStreet() {
        String streetName = streetNameField.getText();
        if (!streetName.isEmpty()) {
            Street newStreet = new Street(streetName);
            insertStreet(newStreet); // Сохранение новой улицы в базе данных
            streetsTable.getItems().add(newStreet); // Добавление новой улицы в таблицу
            streetNameField.clear();
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
    private void loadStreets() {
        String sql = "SELECT * FROM Street";
        try (Connection connection = ConnectBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                streetsTable.getItems().add(new Street(name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editStreet() {
        // Получаем выбранную улицу из таблицы
        Street selectedStreet = streetsTable.getSelectionModel().getSelectedItem();
        if (selectedStreet != null) {
            // Устанавливаем имя выбранной улицы в TextField
            streetNameField.setText(selectedStreet.getName());

            // Добавляем обработчик события для TextField
            streetNameField.setOnAction(event -> {
                String newName = streetNameField.getText();
                if (!newName.isEmpty()) {
                    selectedStreet.setName(newName);
                    // Обновляем запись в таблице
                    streetsTable.refresh();
                    // Обновляем улицу в базе данных
                    updateStreetInDatabase(selectedStreet);

                    // Очищаем TextField
                    streetNameField.clear();
                }
            });
        }
    }


    private void updateStreetInDatabase(Street street) {
        String sql = "UPDATE Street SET name = ? WHERE name = ?";
        try (Connection connection = ConnectBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, street.getName());
            statement.setString(2, street.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void deleteStreet() {
        // Получаем выбранную улицу из таблицы
        Street selectedStreet = streetsTable.getSelectionModel().getSelectedItem();
        if (selectedStreet != null) {
            // Удаляем улицу из таблицы
            streetsTable.getItems().remove(selectedStreet);
            // Удаляем улицу из базы данных
            deleteStreetFromDatabase(selectedStreet);
        }
    }

    private void deleteStreetFromDatabase(Street street) {
        String sql = "DELETE FROM Street WHERE name = ?";
        try (Connection connection = ConnectBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, street.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}