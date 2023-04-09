package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.Panel;
import com.example.solarfx.models.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PanelDetailController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label wattageLabel;

    @FXML
    private TextField priceField;

    @FXML
    private Button saveButton;

    @FXML
    private Button goBackButton;

    private Panel panel;



    public void setData(Panel panel){
        this.panel = panel;
        nameLabel.setText("Panelname: " + panel.getName());
        wattageLabel.setText("Wattage: " + panel.getWattage());
        priceField.setText(String.valueOf(panel.getPrice()));
    }

    private int getPanelIndex() {
        for (int i = 0; i < SolarApplication.panels.size(); i++) {
            if (SolarApplication.panels.get(i).getName().equals(panel.getName())) {
                return i;
            }
        }
        return -1; // Employee not found
    }

    @FXML
    public void savePanel(){
        SolarApplication.panels.get(getPanelIndex()).setPrice(Integer.parseInt(priceField.getText()));
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }

    @FXML
    private void setPanelOverviewScreen() {
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }
}
