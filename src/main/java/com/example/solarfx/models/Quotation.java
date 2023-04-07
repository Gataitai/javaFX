package com.example.solarfx.models;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Quotation {
    private Customer customer;
    private int yearlyEnergyUsage;
    private int roofSurface;
    private boolean threePhaseConnectionNeeded = false;
    private int yieldLoss;
    private ArrayList<Panel> panels = new ArrayList<>();

    public Quotation(Customer customer){
        this.customer = customer;
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

    public void setYieldLoss(int yieldLoss){
        this.yieldLoss = yieldLoss;
    }
}
