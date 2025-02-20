package utils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public SceneLoader(String fxml, javafx.scene.Node currentNode) {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                Parent root = loader.load();

                // Ensure the node has a scene before trying to switch
                if (currentNode.getScene() != null) {
                    currentNode.getScene().setRoot(root);
                } else {
                    // If there's no scene, switch using the window
                    Stage stage = (Stage) currentNode.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load: " + fxml);
            }
        });
    }

}
/*
*
*  FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestion-utilisateur-view.fxml"));
        try {
            Parent root = loader.load();
            cardGestionUtilisateur.getScene().setRoot(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*
*
*
*
* */