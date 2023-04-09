package com.example.solarfx.controllers.admin;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.InstallerGroup;
import com.example.solarfx.models.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeDetailController {

    @FXML
    private Label firstnameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private ComboBox<Role> roles;

    @FXML
    private Button saveButton;

    @FXML
    private Button goBackButton;

    private Employee employee;


    public void initialize() {
        roles.setItems(FXCollections.observableArrayList(Role.values()));
    }

    public void setData(Employee employee){
        this.employee = employee;
        firstnameLabel.setText(employee.getFirstName());
        lastnameLabel.setText(employee.getLastName());
        usernameLabel.setText(employee.getUsername());
        roles.setValue(employee.getRole());
    }

    private int getEmployeeIndex() {
        for (int i = 0; i < SolarApplication.employees.size(); i++) {
            if (SolarApplication.employees.get(i).getUuid().equals(employee.getUuid())) {
                return i;
            }
        }
        return -1; // Employee not found
    }

    @FXML
    public void saveEmployee(){
        System.out.println("INDEX: " + getEmployeeIndex());
        SolarApplication.employees.get(getEmployeeIndex()).setRole(roles.getValue());
        SolarApplication.setScene("admin/employee-overview.fxml");
    }

    @FXML
    private void setEmployeeOverviewScene() {
        SolarApplication.setScene("admin/employee-overview.fxml");
    }
}
