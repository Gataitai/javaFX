package com.example.solarfx.models;

public class Person {
    private final String uuid;
    private final String firstName;
    private final String lastName;

    public Person(String uuid, String firstName, String lastName){
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

}
