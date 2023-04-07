package com.example.solarfx;

import com.example.solarfx.models.Customer;
import com.example.solarfx.models.Employee;
import com.example.solarfx.models.Role;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SolarApplication extends Application {

    //list with customers
    private static ArrayList<Customer> customers = new ArrayList<>();
    //list with employees
    private static ArrayList<Employee> employees = new ArrayList<>();
    //saving stage given in start method
    public static Stage stage;

    @Override
    public void start(Stage stage) {

        employees.add(new Employee(
                "mathijs",
                "pattipeilohy",
                "mpa1",
                "password",
                Role.ADMIN
        ));

        employees.add(new Employee(
                "adam",
                "geerdink",
                "age1",
                "password",
                Role.ADVISEUR
        ));

        employees.add(new Employee(
                "samme",
                "logtmijer",
                "slo1",
                "password",
                Role.PLANNER
        ));

        employees.add(new Employee(
                "bruh",
                "bruh",
                "bbr1",
                "password",
                Role.INSTALLEUR
        ));

        employees.add(new Employee(
                "lmao",
                "lmao",
                "llm1",
                "password",
                Role.INKOOP
        ));

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

    public static void main(String[] args) {
        launch();
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static Customer getCustomerByFirstName(String firstname) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equalsIgnoreCase(firstname)) {
                return customer;
            }
        }
        return null;
    }

    public static Employee getEmployeeByUsername(String username) {
        for (Employee employee : employees) {
            if (employee.getUsername().equalsIgnoreCase(username)) {
                return employee;
            }
        }
        return null;
    }
}