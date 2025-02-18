package models.module4;

import enums.TypeTournois;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournois {
    private int id;
    private String nom;
    private TypeTournois typeTournois;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String image_url;

    private List<MatchSportif> matches;

    public Tournois(int id, String nom, TypeTournois typeTournois, LocalDateTime dateDebut, LocalDateTime dateFin, String image_url) {
        this.id = id;
        this.nom = nom;
        this.typeTournois = typeTournois;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.image_url = image_url;
        this.matches = new ArrayList<MatchSportif>();
    }

    public Tournois(String nom, TypeTournois typeTournois, LocalDateTime dateDebut, LocalDateTime dateFin, String image_url, List<MatchSportif> matches) {
        this.nom = nom;
        this.typeTournois = typeTournois;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.image_url = image_url;
        this.matches = matches;
        this.matches = new ArrayList<MatchSportif>();

    }

    public Tournois() {
        this.matches = new ArrayList<MatchSportif>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeTournois getTypeTournois() {
        return typeTournois;
    }

    public void setTypeTournois(TypeTournois typeTournois) {
        this.typeTournois = typeTournois;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<MatchSportif> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchSportif> matches) {
        this.matches = matches;
    }
}
