package com.example.solarfx.controllers;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class HeaderController {

    @FXML
    private Button adviseurButton;

    @FXML
    private Button plannerButton;

    @FXML
    private Button inkoopButton;

    @FXML
    private Button medewerkerBeheerButton;

    @FXML
    private Button logoutButton;

    @FXML
    private void handleLogout() {
        SolarApplication.setScene("login.fxml");
        SolarApplication.currentLoggedInRole = null;
    }

    public void initialize() {
        adviseurButton.setVisible(false);

        plannerButton.setVisible(false);

        inkoopButton.setVisible(false);

        medewerkerBeheerButton.setVisible(false);
        if(SolarApplication.currentLoggedInRole == Role.ADMIN){
            adviseurButton.setVisible(true);

            plannerButton.setVisible(true);

            inkoopButton.setVisible(true);

            medewerkerBeheerButton.setVisible(true);
        }
    }

    @FXML
    private void setAdviseurScreen() {
        SolarApplication.setScene("adviseur/quotation-overview.fxml");
    }

    @FXML
    private void setPlannerScreen() {
        SolarApplication.setScene("planner/teams-overview.fxml");
    }

    @FXML
    private void setInkoopScreen() {
        SolarApplication.setScene("inkoop/purchase-overview.fxml");
    }

    @FXML
    private void setMedewerkerBeheerScreen() {
        SolarApplication.setScene("admin/employee-overview.fxml");
    }
}
