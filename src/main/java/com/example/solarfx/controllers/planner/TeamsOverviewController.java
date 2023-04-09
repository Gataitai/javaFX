package com.example.solarfx.controllers.planner;

import com.example.solarfx.SolarApplication;
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

public class TeamsOverviewController {

    @FXML
    private Button newTeam;

    @FXML
    private TableView<InstallerGroup> installerGroupTable;

    @FXML
    private TableColumn<InstallerGroup, String> installerGroupColumn;

    @FXML
    private Label groupsAmount;

    public void initialize() {
        groupsAmount.setText("Groups: " + SolarApplication.installerGroups.size());
        ObservableList<InstallerGroup> items = FXCollections.observableArrayList(SolarApplication.installerGroups);

        installerGroupTable.setItems(items);

        installerGroupColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));

        installerGroupTable.getColumns().setAll(installerGroupColumn);

        installerGroupTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                handleInstallerGroupClick();
            }
        });
    }

    @FXML
    private void setNewTeamScene() {
        SolarApplication.setScene("planner/new-team.fxml");
    }

    @FXML
    private void handleInstallerGroupClick() {
        InstallerGroup selectedGroup = installerGroupTable.getSelectionModel().getSelectedItem();
        if (selectedGroup != null) {
            // Pass the selected InstallerGroup object to the next FXML page
            SolarApplication.setScene("planner/team-detail.fxml", selectedGroup);
        }
    }
}
