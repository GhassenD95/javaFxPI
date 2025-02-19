package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.module1.Utilisateur;
import services.module1.ServiceUtilisateur;
import utils.SceneLoader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GestionUtilisateurController {
    @FXML
    private VBox userCardContainer;

    public void initialize() {
        System.out.println("GestionUtilisateurController initialized!");

        Platform.runLater(() -> {
            try {
                List<Utilisateur> utilisateurs = new ServiceUtilisateur().getAll();
                System.out.println(utilisateurs);

                for (Utilisateur utilisateur : utilisateurs) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/partials/card-utilisateur-component.fxml"));
                    Parent root = loader.load();

                    CardUtilisateurViewController controller = loader.getController();
                    controller.setUtilisateur(utilisateur);

                    userCardContainer.getChildren().add(root);

                    System.out.println("Added user: " + utilisateur.getNom());
                }

            } catch (SQLException | IOException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();  // Print full stack trace for debugging
            }
        });
    }

    public void onClickGoToAjout(MouseEvent actionEvent) {
        SceneLoader sceneLoader = new SceneLoader("/views/")

    }
}
