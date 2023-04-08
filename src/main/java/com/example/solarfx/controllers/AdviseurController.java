package com.example.solarfx.controllers;

import com.example.solarfx.SolarApplication;
import com.example.solarfx.models.Customer;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.Panel;
import com.example.solarfx.models.Quotation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AdviseurController {
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
    private void setNewQuotationScene() {
        SolarApplication.setScene("adviseur/new-quotation.fxml");
    }
}

//    private Customer customer;
//    private int yearlyEnergyUsage;
//    private int roofSurface;
//    private boolean threePhaseConnectionNeeded = false;
//    private int yieldLoss;
//    private LocalDate buildDate;
//    private final ArrayList<Panel> panels = new ArrayList<>();
