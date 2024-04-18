package ru.mixail.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MeterReadingHistoryController {
    @FXML
    private ComboBox<String> meterComboBox;

    @FXML
    private TableView<String> historyTable;


    public void initialize() {
        // Метод для инициализации формы
    }

    public void showHistory() {
        // Метод для отображения истории показаний выбранного прибора учета
    }
}
