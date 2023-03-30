package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.exceptions.PseudoDejaPrisException;

import java.util.ArrayList;

public interface IserviceQuizz {
    void traiterUnJoueur(JoueurDTO joueur, int choix) throws PseudoDejaPrisException;
    ArrayList<JoueurDTO> fournirClassementTop3();

    String recupStatsJoueurs();

    ArrayList<JoueurDTO> determinerClassement();
}
