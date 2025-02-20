package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.module1.Utilisateur;

import java.io.IOException;
import java.util.Objects;

public class CardUtilisateurViewController {
    @FXML
    private HBox utilisateurCard;

    @FXML
    private ImageView utilisateurImage;

    @FXML
    private Label utilisateurNom;

    @FXML
    private Label utilisateurPrenom;

    @FXML
    private Label utilisateurEmail;

    @FXML
    private Label utilisateurAdresse;

    @FXML
    private Label utilisateurTelephone;

    @FXML
    private Label utilisateurRole;

    @FXML
    private Label utilisateurStatus;

    @FXML
    private Label utilisateurEquipe;

    private Utilisateur utilisat;

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisat = utilisateur; // Store for later use

        String imageName = utilisateur.getImage_url();

        // Construct the path to the image file inside the resources/images/imageProfile folder
        String imagePath = "/images/profileImages/" + imageName;

        System.out.println("Loading image from: " + imagePath); // Debugging the image path

        // Try to load the image from the resources folder
        Image image = null;
        try {
            image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
            if (image.isError()) {
                throw new IOException("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            // If the image is not found or there's an error, set a default image
            image = new Image(getClass().getResource("/images/profileImages/default.png").toExternalForm());
        }

        // Set the image to the ImageView
        utilisateurImage.setImage(image);

        // Set the other fields
        utilisateurNom.setText(utilisateur.getNom() != null ? utilisateur.getNom() : "N/A");
        utilisateurPrenom.setText(utilisateur.getPrenom() != null ? utilisateur.getPrenom() : "N/A");
        utilisateurEmail.setText(utilisateur.getEmail() != null ? utilisateur.getEmail() : "N/A");
        utilisateurAdresse.setText(utilisateur.getAdresse() != null ? utilisateur.getAdresse() : "N/A");
        utilisateurTelephone.setText(utilisateur.getTelephone() != null ? utilisateur.getTelephone() : "N/A");

        // Handle role and status with null checks
        utilisateurRole.setText(utilisateur.getRole() != null ? String.valueOf(utilisateur.getRole()) : "N/A");
        utilisateurStatus.setText(utilisateur.getStatus() != null ? utilisateur.getStatus().toString() : "N/A");

        // Set the equipe field (if applicable)
        if (utilisateur.getEquipe() != null) {
            utilisateurEquipe.setText(utilisateur.getEquipe().getNom());
        } else {
            utilisateurEquipe.setText("N/A");
        }

    }

    public HBox getCard(){
        return utilisateurCard;
    }

    public void handleClick(MouseEvent mouseEvent) {
        FXMLLoader loder = new FXMLLoader(getClass()
                .getResource("/views/show-user-view.fxml"));
        try {
            Parent root = loder.load();
            ShowUserController controller = loder.getController();
            controller.setUtilisateur(utilisat);
            utilisateurCard.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
