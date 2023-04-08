module com.example.solarfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.solarfx to javafx.fxml;
    exports com.example.solarfx;
    exports com.example.solarfx.controllers;
    opens com.example.solarfx.controllers to javafx.fxml;
    exports com.example.solarfx.controllers.adviseur;
    opens com.example.solarfx.controllers.adviseur to javafx.fxml;
    exports com.example.solarfx.controllers.admin;
    opens com.example.solarfx.controllers.admin to javafx.fxml;
    exports com.example.solarfx.controllers.inkoop;
    opens com.example.solarfx.controllers.inkoop to javafx.fxml;
    exports com.example.solarfx.controllers.installeur;
    opens com.example.solarfx.controllers.installeur to javafx.fxml;
    exports com.example.solarfx.controllers.planner;
    opens com.example.solarfx.controllers.planner to javafx.fxml;
}