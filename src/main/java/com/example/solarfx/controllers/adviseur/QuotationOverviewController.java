package com.example.solarfx.controllers.adviseur;

import com.example.solarfx.SolarApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class QuotationOverviewController {

    @FXML
    private Button newQuotation;

    @FXML
    private void setNewQuotationScene() {
        SolarApplication.setScene("adviseur/new-quotation.fxml");
    }
}
