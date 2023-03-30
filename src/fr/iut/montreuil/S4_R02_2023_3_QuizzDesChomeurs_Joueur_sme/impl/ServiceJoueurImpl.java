package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.impl;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.ListeJoueursDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.ScoreDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.modeles.IserviceJoueur;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.Langue;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.exceptions.PseudoDejaPrisException;

import java.util.ArrayList;

public class ServiceJoueurImpl implements IserviceJoueur {

    private final ListeJoueursDTO joueurs;

    public ServiceJoueurImpl(){
        joueurs = new ListeJoueursDTO(new ArrayList<>());
    }

    @Override
    public void ajouterJoueur(String pseudo, String prenom, String nom, int anneeDeNaissance, Langue languePreferee, String interets) throws PseudoDejaPrisException {
        for(JoueurDTO j : joueurs.getJoueurs()){
            if(j.getPseudo().equals(pseudo)) throw new PseudoDejaPrisException();
        }
        joueurs.getJoueurs().add(new JoueurDTO(pseudo, prenom, nom, anneeDeNaissance, languePreferee, interets));
    }


    @Override
    public void supprimerJoueur(String pseudo) {
        int i = 0;
        boolean supprime = false;
        while(i<joueurs.getJoueurs().size() && !supprime){
            if(joueurs.getJoueurs().get(i).getPseudo().equals(pseudo)) joueurs.getJoueurs().remove(i);
            i++;
        }
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return joueurs.getJoueurs();
    }

    @Override
    public JoueurDTO transmettreInfoJoueur(String pseudo) {
        JoueurDTO joueur = null;
        for(JoueurDTO j : joueurs.getJoueurs()){
            if(j.getPseudo().equals(pseudo)) joueur = j;
        }
        return joueur;
    }

    @Override
    public void gestionScoreJoueur(int points, int temps, String pseudo) {
        for(JoueurDTO j : joueurs.getJoueurs()){
            if(j.getPseudo().equals(pseudo)) j.getScores().add( new ScoreDTO(points, temps));
        }
    }

    @Override
    public String fournirStatsJoueurs() {
        String stats = "";
        for(JoueurDTO j : joueurs.getJoueurs()){
            stats += "Statistiques de " + j.getPseudo() + " : \n";
            if (j.getScores().isEmpty()) stats += j.getPseudo() + " n'a pas encore joué.\n";
            else {
                int partiesJouees, bonnesReponses, moyenne, dureeMoyenne;

                partiesJouees = j.getScores().size();
                bonnesReponses = 0;
                dureeMoyenne = 0;

                for(ScoreDTO score: j.getScores()){
                    bonnesReponses += score.getPoints();
                    dureeMoyenne += score.getTemps();
                }
                dureeMoyenne = dureeMoyenne/partiesJouees;
                moyenne = bonnesReponses/partiesJouees;

                stats += "\t" + partiesJouees + " parties jouées\n\t" + bonnesReponses + " bonnes réponses sur " + (10*partiesJouees)
                        + ".\n\tMoyenne générale : " + moyenne
                        + "/10\n\tDurée moyenne : " + (dureeMoyenne/60) + " min " + (dureeMoyenne%60) + "s\n";

                stats += "\t5 dernières parties jouées : \n";
                int i = 0;
                while(i<partiesJouees && i<5){
                    stats += "\t\t" + (i+1) + j.getScores().get(i).getPoints()
                            + "/10 en " + (j.getScores().get(i).getTemps()/60) + " min " + (j.getScores().get(i).getTemps()%60) + "s";
                    i++;
                }

            }
            stats += "\n";
        }
        return stats;
    }

    @Override
    public ArrayList<JoueurDTO> fournirClassement() {

        ArrayList<JoueurDTO> classement = new ArrayList<>();
        ArrayList<JoueurDTO> listTemp = new ArrayList<>();
        for (int i =0; i< joueurs.getJoueurs().size();i++){
            listTemp.add(joueurs.getJoueurs().get(i));
        }
        for (int i= 0; i<joueurs.getJoueurs().size();i++) {
            JoueurDTO temp = listTemp.get(0);
            double meilleurMoyenne = 0;
            for (int x = 0; x < listTemp.get(0).getScores().size(); x++) {
                meilleurMoyenne += listTemp.get(0).getScores().get(x).getPoints();
            }
            meilleurMoyenne =meilleurMoyenne/listTemp.get(0).getScores().size();
            for (int j = 1; j < listTemp.size(); j++) {
                double moyenneNouv = 0;
                for (int y = 0; y < listTemp.get(j).getScores().size(); y++) {
                    moyenneNouv += listTemp.get(j).getScores().get(y).getPoints();
                }
                moyenneNouv= moyenneNouv/listTemp.get(j).getScores().size();
                if (meilleurMoyenne < moyenneNouv) {
                    meilleurMoyenne = moyenneNouv;
                    temp = listTemp.get(j);
                }
            }
            listTemp.remove(temp);
            classement.add(temp);
        }
        return classement;
    }

}