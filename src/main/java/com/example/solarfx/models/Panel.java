package com.example.solarfx.models;

public class Panel {
    private final String name;
    private final int wattage;
    private int price;

    public Panel(String name, int wattage, int price){
        this.name = name;
        this.price = price;
        this.wattage = wattage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWattage() {
        return wattage;
    }

    public int getPrice() {
        return price;
    }
}
