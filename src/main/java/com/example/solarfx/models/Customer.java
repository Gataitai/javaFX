package com.example.solarfx.models;

public class Customer extends Person{
    private String address;
    private String phoneNumber;

    public Customer(String uuid, String firstName, String lastName, String address, String phoneNumber) {
        super(uuid, firstName, lastName);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
