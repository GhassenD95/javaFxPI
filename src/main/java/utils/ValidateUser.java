package utils;

import models.module1.Utilisateur;

public class ValidateUser {

    public static boolean isValid(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return false;
        }

        // Validate required fields
        if (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty()) {
            return false;  // Name should not be empty
        }
        if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().isEmpty()) {
            return false;  // Prenom should not be empty
        }
        if (utilisateur.getEmail() == null || utilisateur.getEmail().trim().isEmpty()) {
            return false;  // Email should be valid
        }
        if(utilisateur.getImage_url() == null || utilisateur.getImage_url().trim().isEmpty()) {
            return false;
        }
        if (utilisateur.getAdresse() == null || utilisateur.getAdresse().trim().isEmpty()) {
            return false;  // Address should not be empty
        }
        if (utilisateur.getTelephone() == null || utilisateur.getTelephone().trim().isEmpty()) {
            return false;  // Telephone should not be empty
        }
        if (utilisateur.getRole() == null) {
            return false;  // Role should be selected
        }
        if (utilisateur.getStatus() == null) {
            return false;  // Status should be selected
        }

        return true;  // All fields are valid
    }
}
