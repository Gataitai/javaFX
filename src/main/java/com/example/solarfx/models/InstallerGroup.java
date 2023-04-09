package com.example.solarfx.models;

import com.example.solarfx.SolarApplication;

import java.util.ArrayList;

public class InstallerGroup {
    private final String name;
    private ArrayList<Employee> installers = new ArrayList<>();

    public InstallerGroup(String name) {
        this.name = name;
    }

    public InstallerGroup(String name, ArrayList<Employee> installers) {
        this.name = name;
        this.installers = installers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getInstallers() {
        return installers;
    }

    //finds an employee that's also an installer
    private Employee findInstallerByUserName(String username) {
        Employee employee = SolarApplication.getEmployeeByUsername(username);
        if (!employee.getRole().equals(Role.INSTALLEUR)) {
            throw new IllegalArgumentException("Employee with username: " + username + " is not an installer!");
        }
        return employee;
    }

    //shows if the employee exists in the group
    private boolean employeeExists(String username) {
        for (Employee e : installers) {
            if (e.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //adds installer to the group
    public void addInstallerByUsername(String username) {
        Employee employee = findInstallerByUserName(username);
        if (employeeExists(username)) {
            throw new IllegalArgumentException("Installer with name: " + username + " is already in group");
        }
        installers.add(employee);
    }

    //removes installer from the group
    public int removeInstallerByUsername(String username) {
        Employee employee = findInstallerByUserName(username);
        if (!employeeExists(username)) {
            throw new IllegalArgumentException("Installer with name: " + username + " is not in group");
        }
        int index = installers.indexOf(employee);
        installers.remove(index);
        return index;
    }

    @Override
    public String toString() {
        return name;
    }

}
