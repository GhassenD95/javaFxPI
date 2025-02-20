package controllers;

import enums.Role;
import enums.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import models.module1.Equipe;
import models.module1.Utilisateur;
import services.module1.ServiceEquipe;
import services.module1.ServiceUtilisateur;
import utils.SceneLoader;
import utils.ValidateUser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static enums.Role.getRoleNames;

public class AjoutUtilisateurController {



    @FXML
    private Label msgError;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox<String> comboboxRole;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField telephoneField;
    @FXML
    private RadioButton radioButton1;  // Active
    @FXML
    private RadioButton radioButton2;  // Inactive
    @FXML
    private ComboBox<String> comboboxE;
    @FXML
    private StackPane imageUploadContainer;

    @FXML
    public void initialize() {
        loadImageUploadComponent();

        ToggleGroup group = new ToggleGroup();
        radioButton1.setToggleGroup(group);
        radioButton2.setToggleGroup(group);

        comboboxRole.getItems().setAll(getRoleNames());
        try {
            List<String> equipes = new ServiceEquipe().getAll().stream().map(Equipe::getNom).collect(Collectors.toList());
            System.out.println("Equipes size: " + equipes.size());
            System.out.println("Equipes: " + equipes);

            equipes.add(0, "");
            comboboxE.getItems().setAll(equipes);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    private void loadImageUploadComponent() {
        try {
            // Load the image upload component FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/partials/image-upload-component.fxml"));
            AnchorPane imageUploadComponent = loader.load();

            // Add the loaded component into the image upload container
            imageUploadContainer.getChildren().clear(); // Clear any existing content
            imageUploadContainer.getChildren().add(imageUploadComponent); // Add the new content

        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors in loading the FXML
        }
    }

    @FXML
    public void ajouterUtilisateur(ActionEvent actionEvent) {
        msgError.setText("");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nomField.getText());
        utilisateur.setPrenom(prenomField.getText());
        utilisateur.setEmail(emailField.getText());
        utilisateur.setHashedPassword(passwordField.getText());

        String selectedRole = comboboxRole.getSelectionModel().getSelectedItem();
        if (selectedRole != null) {
            utilisateur.setRole(Role.valueOf(selectedRole));
        }

        utilisateur.setAdresse(adresseField.getText());
        utilisateur.setTelephone(telephoneField.getText());

        // Set user status based on radio button selection
        if (radioButton1.isSelected()) {
            utilisateur.setStatus(Status.ACTIVE);
        } else if (radioButton2.isSelected()) {
            utilisateur.setStatus(Status.INACTIVE);
        }

        // Set the selected equipe (team)
        String selectedEquipeName = comboboxE.getSelectionModel().getSelectedItem();
        if (selectedEquipeName != null && !selectedEquipeName.trim().isEmpty() ) {
            try {
                Equipe selectedEquipe = new ServiceEquipe().getAll().stream()
                        .filter(equipe -> equipe.getNom().equals(selectedEquipeName))
                        .findFirst()
                        .orElse(null);

                if (selectedEquipe != null && utilisateur.getRole().name().equals("ATHLETE")) {
                    utilisateur.setEquipe(selectedEquipe);
                }else{
                    utilisateur.setEquipe(null);
                    msgError.setText("Que des athletes peuvent appartenir a une equipe");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Handle image upload
        if (!imageUploadContainer.getChildren().isEmpty()) {
            ImageUploadController imageUploadController = (ImageUploadController) imageUploadContainer.getChildren().get(0).getUserData();
            if (imageUploadController != null) {
                String imageFileName = imageUploadController.getSelectedImagePath();  // This will return the image file name
                if (imageFileName != null && !imageFileName.isEmpty()) {
                    utilisateur.setImage_url(imageFileName);  // Save the image file name in the utilisateur object
                } else {
                    // Handle case where no image file name is selected
                    utilisateur.setImage_url("default.jpg");
                }
            } else {
                utilisateur.setImage_url("default.jpg");

                msgError.setText("Image upload controller is null.");
            }
        } else {
            utilisateur.setImage_url("default.jpg");

            msgError.setText("Please upload an image.");
        }




        System.out.println(utilisateur);

        // Validate and save the user
        if (ValidateUser.isValid(utilisateur)) {
            System.out.println(ValidateUser.isValid(utilisateur));
            try {
                new ServiceUtilisateur().add(utilisateur);
                new SceneLoader("/views/gestion-utilisateur-view.fxml", msgError);
                // Optionally, clear fields or show confirmation message
            } catch (SQLException e) {
                e.printStackTrace();  // Handle database save exception
            }
        } else {
            msgError.setText("Veuillez remplir tous les champs");
        }
    }

}
