package com.example.solarfx.controllers.adviseur;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Customer;
import com.example.solarfx.models.Panel;
import com.example.solarfx.models.Quotation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NewQuotationController {
    @FXML
    private ComboBox<Customer> customers;

    @FXML
    private TextField yearlyEnergyUsage;

    @FXML
    private TextField roofSurface;

    @FXML
    private CheckBox threePhaseNeeded;

    @FXML
    private TextField yieldLoss;

    @FXML
    private ComboBox<Panel> panels;

    @FXML
    private Button submit;

    @FXML
    private Button back;

    private void addNumericListener(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void initialize() {
        customers.setItems(FXCollections.observableArrayList(SolarApplication.customers));

        addNumericListener(yearlyEnergyUsage);
        addNumericListener(roofSurface);
        addNumericListener(yieldLoss);


        panels.setItems(FXCollections.observableArrayList(SolarApplication.panels));
    }

    @FXML
    private void createQuotation() {
        Quotation newQuotation = new Quotation(
                customers.getValue(),
                Integer.parseInt(yearlyEnergyUsage.getText()),
                Integer.parseInt(roofSurface.getText()),
                threePhaseNeeded.isSelected(),
                Integer.parseInt(yieldLoss.getText()),
                panels.getValue(),
                1
        );
        SolarApplication.addQuotation(newQuotation);
        SolarApplication.setScene("adviseur/quotation-overview.fxml");
    }

    @FXML
    private void setOverviewScreen() {
        SolarApplication.setScene("adviseur/quotation-overview.fxml");
    }
}

//    private Customer customer;
//    private int yearlyEnergyUsage;
//    private int roofSurface;
//    private boolean threePhaseConnectionNeeded = false;
//    private int yieldLoss;
//    private LocalDate buildDate;
//    private final ArrayList<Panel> panels = new ArrayList<>();
