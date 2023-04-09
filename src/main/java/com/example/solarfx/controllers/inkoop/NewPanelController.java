package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Panel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewPanelController {

    @FXML
    private TextField panelName;

    @FXML
    private TextField panelWattage;

    @FXML
    private TextField panelPrice;

    @FXML
    private Button createButton;

    @FXML
    private Button goBackButton;

    public void initialize() {
        addNumericListener(panelWattage);
        addNumericListener(panelPrice);
    }

    @FXML
    private void addPanel(){
        Panel panel = new Panel(
                panelName.getText(),
                Integer.parseInt(panelWattage.getText()),
                Integer.parseInt(panelPrice.getText())
        );
        SolarApplication.panels.add(panel);
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }

    private void addNumericListener(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    private void setOverviewScene() {
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }
}
