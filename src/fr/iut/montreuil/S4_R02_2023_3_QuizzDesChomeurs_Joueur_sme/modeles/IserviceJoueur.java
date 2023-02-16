package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;

import java.util.ArrayList;

public interface IserviceJoueur {

    void ajouterJoueur(String nomJoueur);

    void supprimerJoueur(String nomJoueur);

    ArrayList<JoueurDTO> listerJoueurs();

    JoueurDTO transmettreInfoJoueur(String nomJoueur);
}
