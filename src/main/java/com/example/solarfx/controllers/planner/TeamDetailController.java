package com.example.solarfx.controllers.planner;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.InstallerGroup;
import com.example.solarfx.models.Quotation;
import com.example.solarfx.models.Role;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeamDetailController {

    @FXML
    private TextField groupName;

    @FXML
    private ComboBox<Employee> installers;

    @FXML
    private Button addInstallerButton;

    @FXML
    private TableView<Employee> installerTable;

    @FXML
    private TableColumn<Employee, String> fullNameColumn;

    @FXML
    private TableColumn<Employee, String> usernameColumn;

    @FXML
    private TableColumn<Employee, String> removeColumn;

    @FXML
    private Button editButton;

    @FXML
    private Button goBackButton;

    private ArrayList<Employee> addedInstallers = new ArrayList<>();

    public void initialize() {
        groupName.setEditable(false);
        installers.setItems(FXCollections.observableArrayList(SolarApplication.employees.stream().filter(e -> e.getRole() == Role.INSTALLEUR).collect(Collectors.toList())));
    }

    public void setData(InstallerGroup group){
        groupName.setText(group.getName());
        addedInstallers = group.getInstallers();
        buildTable();
    }

    public void buildTable(){
        ObservableList<Employee> employees = FXCollections.observableArrayList(addedInstallers);

        installerTable.setItems(employees);

        fullNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));

        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));

        removeColumn.setCellFactory(column -> new TableCell<>() {
            final Button removeButton = new Button("Remove");

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    removeButton.setOnAction(event -> {
                        Employee employeeToRemove = getTableView().getItems().get(getIndex());
                        addedInstallers.remove(employeeToRemove);
                        installerTable.setItems(FXCollections.observableArrayList(addedInstallers));
                        refreshTable();
                    });
                    setGraphic(removeButton);
                }
            }
        });

        installerTable.getColumns().setAll(fullNameColumn, usernameColumn, removeColumn);
    }

    public void addInstaller(){
        addedInstallers.add(installers.getValue());
        buildTable();
    }

    private void refreshTable() {
        installerTable.getColumns().get(0).setVisible(false);
        installerTable.getColumns().get(0).setVisible(true);
    }

    @FXML
    private void editTeam(){
        InstallerGroup installerGroup = new InstallerGroup(
                groupName.getText(),
                addedInstallers
        );

        SolarApplication.installerGroups.stream().map(g -> Objects.equals(g.getName(), groupName.getText()) ? installerGroup : g).collect(Collectors.toCollection(ArrayList::new));
        SolarApplication.setScene("planner/teams-overview.fxml");
    }

    @FXML
    private void setOverviewScreen() {
        SolarApplication.setScene("planner/teams-overview.fxml");
    }
}
