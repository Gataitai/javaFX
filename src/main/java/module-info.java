module com.example.solarfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.solarfx to javafx.fxml;
    exports com.example.solarfx;
}