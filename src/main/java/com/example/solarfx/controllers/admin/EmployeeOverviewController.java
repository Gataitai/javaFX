package com.example.solarfx.controllers.admin;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.InstallerGroup;
import com.example.solarfx.models.Quotation;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmployeeOverviewController {

    @FXML
    private Button newEmployee;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> firstnameColumn;

    @FXML
    private TableColumn<Employee, String> lastnameColumn;

    @FXML
    private TableColumn<Employee, String> usernameColumn;

    @FXML
    private TableColumn<Employee, String> roleColumn;

    public void initialize() {
        ObservableList<Employee> items = FXCollections.observableArrayList(SolarApplication.employees);

        employeeTable.setItems(items);

        firstnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        lastnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        roleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole().toString()));

        employeeTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                handleEmployeeClick();
            }
        });
    }

    @FXML
    private void setNewEmployeeScene() {
        SolarApplication.setScene("admin/new-employee.fxml");
    }

    @FXML
    private void handleEmployeeClick() {
        Employee employee = employeeTable.getSelectionModel().getSelectedItem();
        if (employee != null) {
            // Pass the selected InstallerGroup object to the next FXML page
            SolarApplication.setScene("admin/employee-detail.fxml", employee);
        }
    }
}
