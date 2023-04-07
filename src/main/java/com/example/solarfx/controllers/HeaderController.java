package com.example.solarfx.controllers;

import com.example.solarfx.SolarApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.solarfx.models.Employee;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.Objects;

public class HeaderController {

    @FXML
    private Button logoutButton;

    @FXML
    private void handleLogout() {
        SolarApplication.setScene("login.fxml");
    }
}
