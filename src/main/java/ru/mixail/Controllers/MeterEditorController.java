package ru.mixail.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MeterEditorController {
    @FXML
    private ComboBox<String> addressComboBox;

    @FXML
    private ComboBox<String> meterTypeComboBox;

    @FXML
    private TextField serialNumberField;
    private Stage previousStage;


    public void addMeter() {
        // Метод для добавления прибора учета к адресу
    }
}
