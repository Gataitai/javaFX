package com.example.solarfx;

import com.example.solarfx.controllers.inkoop.PurchaseDetailController;
import com.example.solarfx.controllers.planner.TeamDetailController;
import com.example.solarfx.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.UUID;

public class SolarApplication extends Application {

    //list with customers
    public static final ArrayList<Customer> customers = new ArrayList<>();
    //list with employees
    public static final ArrayList<Employee> employees = new ArrayList<>();
    //list with installergroups
    public static final ArrayList<InstallerGroup> installerGroups = new ArrayList<>();
    //list with available panels
    public static final ArrayList<Panel> panels = new ArrayList<>();
    //list with all quotations;
    public static final ArrayList<Quotation> quotations = new ArrayList<>();
    public static Stage stage;

    @Override
    public void start(Stage stage) {

        employees.add(new Employee(
                UUID.randomUUID().toString(),
                "mathijs",
                "pattipeilohy",
                "mpa1",
                "password",
                Role.ADMIN
        ));

        employees.add(new Employee(
                UUID.randomUUID().toString(),
                "adam",
                "geerdink",
                "age1",
                "password",
                Role.ADVISEUR
        ));

        employees.add(new Employee(
                UUID.randomUUID().toString(),
                "samme",
                "logtmijer",
                "slo1",
                "password",
                Role.PLANNER
        ));

        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(
                    UUID.randomUUID().toString(),
                    "bruh" + i,
                    "bruh" + i,
                    "bbr"+ i,
                    "password",
                    Role.INSTALLEUR
            ));
        }

        InstallerGroup installerGroup = new InstallerGroup("groep 1");
        installerGroup.addInstallerByUsername("bbr1");
        installerGroup.addInstallerByUsername("bbr2");
        installerGroups.add(installerGroup);


        employees.add(new Employee(
                UUID.randomUUID().toString(),
                "lmao",
                "lmao",
                "llm1",
                "password",
                Role.INKOOP
        ));

        panels.add(new Panel(
                "paneeltje",
                200,
                200
        ));

        for (int i = 0; i < 10; i++) {
            customers.add(new Customer(
                    UUID.randomUUID().toString(),
                    "john" + i,
                    "doe" + i,
                    "address" + i,
                    "0612345689"
            ));
        }

        SolarApplication.stage = stage;
        setScene("login.fxml");
    }

    public static void setScene(String fxml){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SolarApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            System.err.println(e);
        }
    }

    public static void setScene(String fxmlFile, Object data) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SolarApplication.class.getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Pass the selected InstallerGroup object to the next controller
            if (data != null) {
                Object controller = loader.getController();
                if (controller instanceof TeamDetailController) {
                    ((TeamDetailController) controller).setData((InstallerGroup) data);
                }
                if (controller instanceof PurchaseDetailController) {
                    ((PurchaseDetailController) controller).setData((Quotation) data);
                }
            }

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void addPanel(Panel panel) {
        panels.add(panel);
    }

    public static void addInstallerGroup(InstallerGroup installerGroup) {
        installerGroups.add(installerGroup);
    }

    public static void addQuotation(Quotation quotation) {
        quotations.add(quotation);
    }

    public static Customer getCustomerByFirstName(String firstname) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equalsIgnoreCase(firstname)) {
                return customer;
            }
        }
        throw new NoSuchElementException("Customer with firstName: " + firstname + " doesnt exist!");
    }

    public static Panel getPanelByName(String panelName) {
        for (Panel panel : panels) {
            if (panel.getName().equalsIgnoreCase(panelName)) {
                return panel;
            }
        }
        throw new NoSuchElementException("Panel with name: " + panelName + " doesnt exist!");
    }

    public static InstallerGroup getInstallerGroupByName(String name) {
        for (InstallerGroup installerGroup : installerGroups) {
            if (installerGroup.getName().equalsIgnoreCase(name)) {
                return installerGroup;
            }
        }
        throw new NoSuchElementException("InstallerGroup with name: " + name + " doesnt exist!");
    }

    public static Employee getEmployeeByUsername(String username) {
        for (Employee employee : employees) {
            if (employee.getUsername().equalsIgnoreCase(username)) {
                return employee;
            }
        }
        throw new NoSuchElementException("Employee with username: " + username + " doesnt exist!");
    }
}