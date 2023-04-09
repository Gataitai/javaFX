package com.example.solarfx.controllers.admin;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class NewEmployeeController {
    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<Role> roles;

    @FXML
    private Button createButton;

    @FXML
    private Button goBackButton;


    public void initialize() {
        roles.setItems(FXCollections.observableArrayList(Role.values()));
    }

    @FXML
    public void addEmployee(){
        Employee employee = new Employee(
                firstnameField.getText(),
                lastnameField.getText(),
                usernameField.getText(),
                passwordField.getText(),
                roles.getValue()
        );
        SolarApplication.addEmployee(employee);
        SolarApplication.setScene("admin/employee-overview.fxml");
    }

    @FXML
    private void setEmployeeOverviewScene() {
        SolarApplication.setScene("admin/employee-overview.fxml");
    }
}
