package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto;


import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.Langue;

import java.util.ArrayList;

public class JoueurDTO {


    private ArrayList<ScoreDTO> scores;
    private String prenom;
    private String nom;
    private String pseudo;
    private int anneeDeNaissance;
    private Langue languePreferee;
    private String interets;


    public JoueurDTO(String pseudo, String prenom, String nom, int anneeDeNaissance, Langue languePreferee, String interets) {
        this.scores = new ArrayList<>();
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.nom = nom;
        this.anneeDeNaissance = anneeDeNaissance;
        this.languePreferee = languePreferee;
        this.interets = interets;
    }

    public ArrayList<ScoreDTO> getScores() {
        return scores;
    }

    public void setScore(ArrayList<ScoreDTO> scores) {
        this.scores = scores;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public void setAnneeDeNaissance(int anneeDeNaissance) {
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public String getInterets() {
        return interets;
    }

    public void setInterets(String interets) {
        this.interets = interets;
    }

    public Langue getLanguePreferee() {
        return languePreferee;
    }

    public void setLanguePreferee(Langue languePreferee) {
        this.languePreferee = languePreferee;
    }
}