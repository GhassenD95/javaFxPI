package com.gus.javafxpi;

import services.module1.ServiceEquipe;
import services.module1.ServiceUtilisateur;
import tools.DbConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new ServiceEquipe().getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
