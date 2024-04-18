package ru.mixail.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MeterReadingEditorController {
    @FXML
    private ComboBox<String> meterComboBox;

    @FXML
    private TextField readingField;
    private Stage previousStage;


    public void addReading() {
        // Метод для добавления показания прибора учета
    }
}
