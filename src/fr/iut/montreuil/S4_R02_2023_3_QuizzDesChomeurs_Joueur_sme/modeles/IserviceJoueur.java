package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.Langue;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.exceptions.PseudoDejaPrisException;

import java.util.ArrayList;

public interface IserviceJoueur {

    void ajouterJoueur(String pseudo, String prenom, String nom, int anneeDeNaissance, Langue languePreferee, String interets) throws PseudoDejaPrisException;

    void supprimerJoueur(String pseudo);

    ArrayList<JoueurDTO> listerJoueurs();

    JoueurDTO transmettreInfoJoueur(String pseudo);

    void gestionScoreJoueur(int points, int temps, String pseudo);

    String fournirStatsJoueurs();

    ArrayList<JoueurDTO> fournirClassement();

}