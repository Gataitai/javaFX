package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
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

    @FXML
    private void setOverviewScene() {
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }
}
