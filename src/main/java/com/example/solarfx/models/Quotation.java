package com.example.solarfx.models;

import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.util.ArrayList;

public class Quotation {

    private Customer customer;
    private int yearlyEnergyUsage;
    private int roofSurface;
    private boolean threePhaseConnectionNeeded = false;
    private int yieldLoss;
    private LocalDate buildDate;
    private final ArrayList<Panel> panels = new ArrayList<>();

    public Quotation(Customer customer, int yearlyEnergyUsage, int roofSurface, boolean threePhaseConnectionNeeded, int yieldLoss) {
        this.customer = customer;
        this.yearlyEnergyUsage = yearlyEnergyUsage;
        this.roofSurface = roofSurface;
        this.threePhaseConnectionNeeded = threePhaseConnectionNeeded;
        this.yieldLoss = yieldLoss;
    }

    public void addPanel(Panel panel){
        this.panels.add(panel);
    }

    public void setYearlyEnergyUsage(int yearlyEnergyUsage){
        this.yearlyEnergyUsage = yearlyEnergyUsage;
    }

    public void setRoofSurface(int roofSurface){
        this.roofSurface = roofSurface;
    }

    public void checkThreePhaseConnection(){
        this.threePhaseConnectionNeeded = true;
    }

    public void setBuildDate(LocalDate date){
        this.buildDate = date;
    }

    public void setYieldLoss(int yieldLoss){
        this.yieldLoss = yieldLoss;
    }
}
