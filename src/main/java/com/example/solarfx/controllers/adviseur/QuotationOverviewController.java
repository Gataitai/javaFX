package com.example.solarfx.controllers.adviseur;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Customer;
import com.example.solarfx.models.Quotation;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;

public class QuotationOverviewController {

    @FXML
    private Button newQuotation;

    @FXML
    private TableView<Quotation> quotationTable;

    @FXML
    private TableColumn<Quotation, String> customerColumn;

    @FXML
    private Label quotationsAmount;

    public void initialize() {
        quotationsAmount.setText("Quotations: " + SolarApplication.quotations.size());
        ObservableList<Quotation> items = FXCollections.observableArrayList(SolarApplication.quotations);

        quotationTable.setItems(items);

        customerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));

        quotationTable.getColumns().setAll(customerColumn);
    }

    @FXML
    private void setNewQuotationScene() {
        SolarApplication.setScene("adviseur/new-quotation.fxml");
    }

}
