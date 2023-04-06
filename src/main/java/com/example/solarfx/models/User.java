package com.example.solarfx.models;

public class User extends Person {

    private final String password;

    public User(String firstName, String lastName, String password){
        super(firstName, lastName);
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
