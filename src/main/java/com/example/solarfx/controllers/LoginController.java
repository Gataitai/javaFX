package com.example.solarfx.controllers;

import com.example.solarfx.SolarApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.solarfx.models.Employee;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLoginButtonAction() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (checkLoginCredentials(username, password)) {
            //switch for employee role. since employee is checked first employee can never be null in this part of the scope.
            Employee employee = SolarApplication.getEmployeeByUsername(username);
            switch (employee.getRole()) {
                case INSTALLEUR -> SolarApplication.setScene("installeur/installeur-overview.fxml");
                case ADVISEUR -> SolarApplication.setScene("adviseur/quotation-overview.fxml");
                case INKOOP -> SolarApplication.setScene("inkoop/purchase-overview.fxml");
                case PLANNER -> SolarApplication.setScene("planner/teams-overview.fxml");
            }
        } else {
            errorLabel.setTextFill(Paint.valueOf("red"));
            errorLabel.setText("Wrong username or password!");
        }
    }

    private boolean checkLoginCredentials(String username, String password) {
        Employee employee = SolarApplication.getEmployeeByUsername(username);
        if(employee == null){
            return false;
        }else{
            return employee.checkPassword(password);
        }
    }
}
