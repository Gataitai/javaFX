package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.InstallerGroup;
import com.example.solarfx.models.Panel;
import com.example.solarfx.models.Quotation;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PurchaseOverviewController {

    @FXML
    private Button newPanel;

    @FXML
    private TableView<Panel> panelsTable;

    @FXML
    private TableColumn<Panel, String> panelsNameColumn;
    @FXML
    private TableColumn<Panel, String> panelsPriceColumn;

    @FXML
    private TableView<Quotation> quotationsTable;

    @FXML
    private TableColumn<Quotation, String> quotationsColumn;

    public void initialize() {
        ObservableList<Panel> panels = FXCollections.observableArrayList(SolarApplication.panels);
        ObservableList<Quotation> quotations = FXCollections.observableArrayList(SolarApplication.quotations);

        panelsTable.setItems(panels);
        quotationsTable.setItems(quotations);

        panelsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        panelsPriceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));
        quotationsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));

        panelsTable.getColumns().setAll(panelsNameColumn, panelsPriceColumn);
        quotationsColumn.getColumns().setAll(quotationsColumn);
    }

    @FXML
    private void setNewPanelScene() {
        SolarApplication.setScene("inkoop/new-panel.fxml");
    }

//    @FXML
//    private void handleInstallerGroupClick() {
//        InstallerGroup selectedGroup = installerGroupTable.getSelectionModel().getSelectedItem();
//        if (selectedGroup != null) {
//            // Pass the selected InstallerGroup object to the next FXML page
//            SolarApplication.setScene("planner/team-detail.fxml", selectedGroup);
//        }
//    }
}
