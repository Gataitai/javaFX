package com.example.solarfx.controllers.adviseur;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NewQuotationController {
    @FXML
    private ComboBox<Customer> customer;

    @FXML
    private TextField yearlyEnergyUsage;

    @FXML
    private TextField roofSurface;

    @FXML
    private CheckBox threePhaseNeeded;

    @FXML
    private TextField yieldLoss;

    @FXML
    private ChoiceBox<Customer> panels;

    @FXML
    private Button submit;

    @FXML
    private Button back;

    public void initialize() {
        customer.setItems(FXCollections.observableArrayList(SolarApplication.customers));

        customer.setEditable(true);

        panels.setItems(FXCollections.observableArrayList(SolarApplication.customers));
    }

    @FXML
    private void createQuotation() {
        System.out.println("lmao");
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
