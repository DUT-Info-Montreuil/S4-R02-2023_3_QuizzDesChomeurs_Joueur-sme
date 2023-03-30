package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.impl;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles.IserviceJoueur;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles.IserviceQuizz;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.exceptions.PseudoDejaPrisException;

import java.util.ArrayList;

public class ServiceQuizzImpl implements IserviceQuizz {

    private ServiceJoueurImpl serviceJoueur;

    @Override
    public void traiterUnJoueur(JoueurDTO joueur, int choix) throws PseudoDejaPrisException {
        switch (choix){
            case 1:
                serviceJoueur.ajouterJoueur(joueur.getPseudo(), joueur.getPrenom(),joueur.getNom(),joueur.getAnneeDeNaissance(),joueur.getLanguePreferee(),joueur.getInterets());
            case 2:
                serviceJoueur.supprimerJoueur(joueur.getPseudo());
        }
    }

    @Override
    public ArrayList<JoueurDTO> fournirClassementTop3() {
        ArrayList<JoueurDTO> top3= new ArrayList<>();
        for (int i =0; i<3;i++){
            top3.add(serviceJoueur.fournirClassement().get(i));
        }
       return top3;
    }

    @Override
    public String recupStatsJoueurs() {
        return null;
        //nous avions fai au lieu d'un fournirstatJoueur un fournirsatsJoueurs donc il fait déjà ce que recupStatsJoueurs fait
    }

    @Override
    public ArrayList<JoueurDTO> determinerClassement() {
        return null;
        //je n'ai pas compris la différence avec fournir classement
    }


}
