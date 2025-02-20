package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.module1.Utilisateur;

public class ShowUserController {
    private Utilisateur utilisateur;


    @FXML
    private Label adresseLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label equipeLabel;

    @FXML
    private ImageView imgId;

    @FXML
    private Label nomLabel;

    @FXML
    private Label prenomLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label telephoneLabel;



    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

        // Update labels with user data
        nomLabel.setText(utilisateur.getNom() != null ? utilisateur.getNom() : "N/A");
        prenomLabel.setText(utilisateur.getPrenom() != null ? utilisateur.getPrenom() : "N/A");
        emailLabel.setText(utilisateur.getEmail() != null ? utilisateur.getEmail() : "N/A");
        adresseLabel.setText(utilisateur.getAdresse() != null ? utilisateur.getAdresse() : "N/A");
        telephoneLabel.setText(utilisateur.getTelephone() != null ? utilisateur.getTelephone() : "N/A");
        roleLabel.setText(utilisateur.getRole() != null ? utilisateur.getRole().toString() : "N/A");
        statusLabel.setText(utilisateur.getStatus() != null ? utilisateur.getStatus().toString() : "N/A");
        equipeLabel.setText(utilisateur.getEquipe() != null ? utilisateur.getEquipe().getNom() : "N/A");

        // Load and display profile image
        try {
            String imagePath = "/images/profileImages/" + utilisateur.getImage_url();
            Image image = new Image(getClass().getResource(imagePath).toExternalForm());
            imgId.setImage(image);
        } catch (Exception e) {
            imgId.setImage(new Image(getClass().getResource("/images/profileImages/default.png").toExternalForm()));
        }
    }

}
