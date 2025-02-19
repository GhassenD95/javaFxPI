package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AjoutUtilisateurController {

    @FXML
    private AnchorPane imageUploadContainer;

    @FXML
    public void initialize() {
        loadImageUploadComponent();
    }

    private void loadImageUploadComponent() {
        try {
            // Load the image upload component FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/partials/card-utilisateur-component.fxml"));
            AnchorPane imageUploadComponent = loader.load();

            // Add the loaded component into the image upload container
            imageUploadContainer.getChildren().clear(); // Clear any existing content
            imageUploadContainer.getChildren().add(imageUploadComponent); // Add the new content

        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors in loading the FXML
        }
    }
}
