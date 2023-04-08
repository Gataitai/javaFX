package com.example.solarfx.models;

import com.example.solarfx.SolarApplication;

import java.util.ArrayList;

public class InstallerGroup {
    private final String name;
    private final ArrayList<Employee> installers = new ArrayList<>();

    public InstallerGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    //gets all the tasks on a given date
//    public ArrayList<Task> getTasksByDate(LocalDate date) {
//        ArrayList<Task> tasksOnDate = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getDate().equals(date)) {
//                tasksOnDate.add(task);
//            }
//        }
//        return tasksOnDate;
//    }
}
