package models.module5;

import models.module1.Equipe;
import models.module4.MatchSportif;

public class PerformanceEquipe {
    private int id;
    private Equipe equipe;
    private MatchSportif matchSportif;
    private int scoreEquipe1;
    private int scoreEquipe2;
    private double possessionBalle;
    private int contres;
    private int fautes;
    private int cartonsJaunes;
    private int cartonsRouges;

    public PerformanceEquipe() {
    }

    public PerformanceEquipe(Equipe equipe, MatchSportif matchSportif, int scoreEquipe1, int scoreEquipe2, double possessionBalle, int contres, int fautes, int cartonsJaunes, int cartonsRouges) {
        this.equipe = equipe;
        this.matchSportif = matchSportif;
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
        this.possessionBalle = possessionBalle;
        this.contres = contres;
        this.fautes = fautes;
        this.cartonsJaunes = cartonsJaunes;
        this.cartonsRouges = cartonsRouges;
    }

    public PerformanceEquipe(int id, Equipe equipe, MatchSportif matchSportif, int scoreEquipe1, int scoreEquipe2, double possessionBalle, int contres, int fautes, int cartonsJaunes, int cartonsRouges) {
        this.id = id;
        this.equipe = equipe;
        this.matchSportif = matchSportif;
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
        this.possessionBalle = possessionBalle;
        this.contres = contres;
        this.fautes = fautes;
        this.cartonsJaunes = cartonsJaunes;
        this.cartonsRouges = cartonsRouges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public MatchSportif getMatchSportif() {
        return matchSportif;
    }

    public void setMatchSportif(MatchSportif matchSportif) {
        this.matchSportif = matchSportif;
    }

    public int getScoreEquipe1() {
        return scoreEquipe1;
    }

    public void setScoreEquipe1(int scoreEquipe1) {
        this.scoreEquipe1 = scoreEquipe1;
    }

    public int getScoreEquipe2() {
        return scoreEquipe2;
    }

    public void setScoreEquipe2(int scoreEquipe2) {
        this.scoreEquipe2 = scoreEquipe2;
    }

    public double getPossessionBalle() {
        return possessionBalle;
    }

    public void setPossessionBalle(double possessionBalle) {
        this.possessionBalle = possessionBalle;
    }

    public int getContres() {
        return contres;
    }

    public void setContres(int contres) {
        this.contres = contres;
    }

    public int getFautes() {
        return fautes;
    }

    public void setFautes(int fautes) {
        this.fautes = fautes;
    }

    public int getCartonsJaunes() {
        return cartonsJaunes;
    }

    public void setCartonsJaunes(int cartonsJaunes) {
        this.cartonsJaunes = cartonsJaunes;
    }

    public int getCartonsRouges() {
        return cartonsRouges;
    }

    public void setCartonsRouges(int cartonsRouges) {
        this.cartonsRouges = cartonsRouges;
    }
}
