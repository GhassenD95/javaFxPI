package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import models.module2.Entrainment;
import services.module2.ServiceEntrainment;

import java.sql.SQLException;
import java.util.List;


public class ListerEntrainments {
    @FXML
    private ListView<String> entrainementListView; // The ListView that will show all entrainments

    // Service that provides access to entrainments
    private ServiceEntrainment serviceEntrainment;

    // Constructor (used for dependency injection if needed)
    public void AjoutEntrainmentView() {
        this.serviceEntrainment = new ServiceEntrainment();
    }

    @FXML
    private void initialize() {
        // Fetch all entrainments from the service
        List<Entrainment> entrainments = null;
        try {
            entrainments = serviceEntrainment.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Create an ObservableList to hold the string representations of the entrainments
        ObservableList<String> entrainementItems = FXCollections.observableArrayList();

        // Convert each entrainment object to a string (you can customize this to show more details)
        for (Entrainment entrainment : entrainments) {
            String itemText = "Nom: " + entrainment.getNom() + "\nDescription: " + entrainment.getDescription();
            entrainementItems.add(itemText);
        }

        // Set the items of the ListView
        entrainementListView.setItems(entrainementItems);
    }

}
