module ru.mixail.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ru.mixail.app to javafx.fxml;
    exports ru.mixail.app;
    exports ru.mixail.Controllers;
    opens ru.mixail.Controllers to javafx.fxml;
}