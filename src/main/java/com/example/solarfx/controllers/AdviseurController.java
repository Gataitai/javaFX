package com.example.solarfx.controllers;

import com.example.solarfx.models.Customer;
import com.example.solarfx.models.Panel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdviseurController {
    private static final String[] OPTIONS = {"Apple", "Banana", "Cherry", "Durian", "Elderberry", "Fig"};
    @FXML
    private ComboBox<String> customer;

    @FXML
    private TextField yearlyEnergyUsage;

    @FXML
    private TextField roofSurface;

    @FXML
    private CheckBox threePhaseConnectionNeeded;

    @FXML
    private TextField yieldLoss;

    @FXML
    private ComboBox<String> panels;



    public void initialize() {
        customer.setItems(FXCollections.observableArrayList(OPTIONS));
        customer.setEditable(true);

        panels.setItems(FXCollections.observableArrayList(OPTIONS));
        panels.setEditable(true);
    }
}

//    private Customer customer;
//    private int yearlyEnergyUsage;
//    private int roofSurface;
//    private boolean threePhaseConnectionNeeded = false;
//    private int yieldLoss;
//    private LocalDate buildDate;
//    private final ArrayList<Panel> panels = new ArrayList<>();
