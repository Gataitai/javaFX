package com.example.solarfx.controllers.inkoop;

import com.example.solarfx.SolarApplication;
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

        quotationsTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 1) {
                handleQuotationClick();
            }
        });
    }

    @FXML
    private void setNewPanelScene() {
        SolarApplication.setScene("inkoop/new-panel.fxml");
    }

    @FXML
    private void handleQuotationClick() {
        Quotation quotation = quotationsTable.getSelectionModel().getSelectedItem();
        if (quotation != null) {
            // Pass the selected InstallerGroup object to the next FXML page
            SolarApplication.setScene("inkoop/purchase-detail.fxml", quotation);
        }
    }

}
