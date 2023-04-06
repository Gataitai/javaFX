package com.example.solarfx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLoginButtonAction() throws IOException {
        String gebruikersnaam = usernameField.getText();
        String wachtwoord = passwordField.getText();

        if (checkLoginCredentials(gebruikersnaam, wachtwoord)) {
//            // Maak een nieuwe FXML loader aan voor de volgende view
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
//
//            // Laad de inhoud van de nieuwe view in een Parent node
//            Parent volgendeViewParent = loader.load();
//
//            // Haal een verwijzing naar de huidige Stage (venster) op
//            Stage huidigeStage = (Stage) submitButton.getScene().getWindow();
//
//            // Maak een nieuwe Scene aan met de inhoud van de volgende view
//            Scene volgendeViewScene = new Scene(volgendeViewParent);
//
//            // Verander de Scene van de huidige Stage naar de nieuwe Scene
//            huidigeStage.setScene(volgendeViewScene);
//            huidigeStage.show();
        } else {
            errorLabel.setText("Wrong username or password.");
        }
    }

    private boolean checkLoginCredentials(String gebruikersnaam, String wachtwoord) {
        // Voer hier de logica uit om de gebruikersnaam en het wachtwoord te controleren
        return true; // vervang deze regel met de daadwerkelijke logica
    }
}
