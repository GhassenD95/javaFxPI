package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ImageUploadController {

    @FXML
    private Label imageUploadMessage;

    private String selectedImagePath;  // Store the path of the selected image

    public void imageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));

        // Show the file chooser dialog
        Stage stage = (Stage) imageUploadMessage.getScene().getWindow(); // Get the current stage
        File selectedFile = fileChooser.showOpenDialog(stage); // Open file chooser dialog

        if (selectedFile != null) {
            // If a file is selected, store only the file name
            selectedImagePath = selectedFile.getName();  // Store just the file name
            imageUploadMessage.setText(selectedFile.getName());  // Display the file name in the label
        } else {
            // If no file is selected, set a message indicating no file was selected
            imageUploadMessage.setText("pas d'image");
        }
    }



    // Getter method to retrieve the image path
    public String getSelectedImagePath() {
        return selectedImagePath;
    }
}

