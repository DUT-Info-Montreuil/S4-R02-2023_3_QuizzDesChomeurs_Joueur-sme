package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.impl;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.ListeJoueursDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles.IserviceJoueur;

import java.util.ArrayList;

public class ServiceJoueurImpl implements IserviceJoueur {

    private final ListeJoueursDTO joueurs;

    public ServiceJoueurImpl(){
        joueurs = new ListeJoueursDTO(new ArrayList<>());
    }

    @Override
    public void ajouterJoueur(String nomJoueur) {
        joueurs.getJoueurs().add(new JoueurDTO(0, nomJoueur));
        //TODO
    }

    @Override
    public void supprimerJoueur(String nomJoueur) {
    //TODO
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return joueurs.getJoueurs();
    }

    @Override
    public JoueurDTO transmettreInfoJoueur(String nomJoueur) {
        //TODO
        return null;
    }
}
