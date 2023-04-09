package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Quotation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PurchaseDetailController {

    @FXML
    private Label quotationName;

    @FXML
    private TextField panelName;

    @FXML
    private Label amountLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Button goBackButton;

    public void initialize() {
        panelName.setEditable(false);
    }

    public void setData(Quotation quotation){
        quotationName.setText(String.valueOf(quotation));
        panelName.setText(quotation.getPanel().getName());
        amountLabel.setText("x " + quotation.getPanelAmount());
        priceLabel.setText("€ " + quotation.getPanel().getPrice() * quotation.getPanelAmount() + ",-");
    }

    @FXML
    private void setOverviewScene() {
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }

}
