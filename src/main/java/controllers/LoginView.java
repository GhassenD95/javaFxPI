package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.module1.Utilisateur;
import services.module1.ServiceUtilisateur;
import tools.DbConnection;
import utils.Auth;
import utils.SceneLoader;
import utils.Session;

import java.io.IOException;
import java.sql.SQLException;

public class LoginView {
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label appMessage;

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (email.isEmpty() || password.isEmpty()) {
            appMessage.setText("Veuillez remplir tous les champs");
        }else{
            boolean auth = new Auth().login(email, password);
            if (auth) {
                String fxml = "/hello-view.fxml";
                new SceneLoader(fxml, emailField);
            }else{
                appMessage.setText("identifiant ou mot de passe incorrect");
            }
        }
    }

}
