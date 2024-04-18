package ru.mixail.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ru.mixail.essense.Street;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreetEditorController {

    @FXML
    private TextField streetNameField;

    @FXML
    private TableView<Street> streetsTable;


    @FXML
    private void addStreet() {

    }


    public void editStreet() {
        // Метод для редактирования улицы
    }

    public void deleteStreet() {
        // Метод для удаления улицы
    }
}