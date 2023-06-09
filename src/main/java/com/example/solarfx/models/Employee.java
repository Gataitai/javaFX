package com.example.solarfx.models;

import java.util.UUID;

public class Employee extends Person {
    private final String username;
    private final String password;
    private Role role;

    public Employee(String firstName, String lastName, String username, String password, Role role){
        super(UUID.randomUUID().toString(), firstName, lastName);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
