package ru.mixail.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane content;

    @FXML
    void redactStreet() {
        loadContent("/street-editor.fxml");
    }

    @FXML
    void reading() {
        loadContent("/meter-editor.fxml");
    }

    @FXML
    void redactMeterType() {
        loadContent("/meter-reading-editor.fxml");
    }

    @FXML
    void viewHistory() {
        loadContent("/meter-reading-history.fxml");
    }

    private void loadContent(String fxmlPath) {
        try {
            this.content.getChildren().clear();
            // Загрузите FXML для контента
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();

            // Добавьте содержимое на сцену
            this.content.getChildren().add(content);

            // Установите местоположение содержимого на сцене
            AnchorPane.setTopAnchor(content, 0.0);
            AnchorPane.setLeftAnchor(content, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
