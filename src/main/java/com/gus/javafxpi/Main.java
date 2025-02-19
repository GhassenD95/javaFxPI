package com.gus.javafxpi;

import services.module1.ServiceEquipe;
import services.module1.ServiceUtilisateur;
import tools.DbConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new ServiceUtilisateur().get(17));
            System.out.println(new ServiceEquipe().get(17));
        } catch (SQLException e) {
            System.out.println("erreur");
        }
    }
}
