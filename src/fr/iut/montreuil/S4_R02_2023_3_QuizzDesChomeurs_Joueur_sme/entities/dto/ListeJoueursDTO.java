package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto;

import java.util.ArrayList;

public class ListeJoueursDTO {

    private ArrayList<JoueurDTO> joueurs;

    public ListeJoueursDTO(ArrayList<JoueurDTO> joueurs) {
        this.joueurs = joueurs;
    }

    public ArrayList<JoueurDTO> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<JoueurDTO> joueurs) {
        this.joueurs = joueurs;
    }


}
