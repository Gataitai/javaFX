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
    private Panel panel;
    private int panelAmount;

    public Quotation(Customer customer, int yearlyEnergyUsage, int roofSurface, boolean threePhaseConnectionNeeded, int yieldLoss, Panel panel, int panelAmount) {
        this.customer = customer;
        this.yearlyEnergyUsage = yearlyEnergyUsage;
        this.roofSurface = roofSurface;
        this.threePhaseConnectionNeeded = threePhaseConnectionNeeded;
        this.yieldLoss = yieldLoss;
        this.panel = panel;
        this.panelAmount = panelAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getYearlyEnergyUsage() {
        return yearlyEnergyUsage;
    }

    public int getRoofSurface() {
        return roofSurface;
    }

    public boolean isThreePhaseConnectionNeeded() {
        return threePhaseConnectionNeeded;
    }

    public int getYieldLoss() {
        return yieldLoss;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public Panel getPanel() {
        return panel;
    }

    public int getPanelAmount() {
        return panelAmount;
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

    @Override
    public String toString() {
        return "Quotation for " + getCustomer().getFirstName() + " " + getCustomer().getLastName();
    }
}
