package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.impl;

import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto.ListeJoueursDTO;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.Langue;
import fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.utils.exceptions.PseudoDejaPrisException;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class ServiceJoueurTest {


    ServiceJoueurImpl service = new ServiceJoueurImpl();


    /*public void ajouterJoueur( String pseudo, String prenom, String nom, int anneeDeNaissance, int languePreferee, String interets) {
        joueurs.getJoueurs().add(new JoueurDTO(pseudo, prenom, nom, anneeDeNaissance, languePreferee, interets));
    }*/


    @Test
    public void testAjouterJoueur() throws PseudoDejaPrisException {
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003, Langue.fra,"jouer");
        assertEquals(1, service.listerJoueurs().size());
        assertEquals(2003,service.listerJoueurs().get(0).getAnneeDeNaissance());
        assertEquals("Antoine",service.listerJoueurs().get(0).getPrenom());
        assertEquals("puradosama",service.listerJoueurs().get(0).getPseudo());
        assertEquals("Bouche",service.listerJoueurs().get(0).getNom());
        assertEquals(2,service.listerJoueurs().get(0).getLanguePreferee());
        assertEquals("jouer",service.listerJoueurs().get(0).getInterets());


    }

    @Test
    public void testAjouterJoueurException(){
       assertThrows(PseudoDejaPrisException.class, () -> {
            service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003, Langue.fra,"jouer");
            service.ajouterJoueur("puradosama", "luc", "Xiang", 2003, Langue.fra,"");
       });
    }

    @Test
    public void testSupprimerJoueur() throws PseudoDejaPrisException {
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003,Langue.fra,"jouer");
        assertEquals(1,service.listerJoueurs().size());
        service.supprimerJoueur("puradosama");
        assertEquals(0,service.listerJoueurs().size());
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003,Langue.fra,"jouer");
        service.ajouterJoueur("mana", "Lucas", "Astier", 2003,Langue.fra,"touhou");
        service.supprimerJoueur("puradosama");
        assertEquals("mana", service.listerJoueurs().get(0).getPseudo());
        service.supprimerJoueur("existePas");
        assertEquals(2,this.service.listerJoueurs().size());
    }
    @Test
    public void testListerJoueur() throws PseudoDejaPrisException {
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003,Langue.fra,"jouer");
        service.ajouterJoueur("mana", "Lucas", "Astier", 2003,Langue.fra,"touhou");
        assertEquals("puradosama",service.listerJoueurs().get(0).getPseudo());
        assertEquals("mana",service.listerJoueurs().get(1).getPseudo());
    }

    @Test
    public void testTransmettreInfoJoueur() throws PseudoDejaPrisException {
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003,Langue.fra,"jouer");
        service.ajouterJoueur("mana", "Lucas", "Astier", 2003,Langue.fra,"touhou");
        assertEquals("Antoine",service.transmettreInfoJoueur("puradosama").getPrenom());
        assertEquals("Bouche",service.transmettreInfoJoueur("puradosama").getNom());
        assertEquals(2003,service.transmettreInfoJoueur("puradosama").getAnneeDeNaissance());
        assertEquals(2,service.transmettreInfoJoueur("puradosama").getLanguePreferee());
        assertEquals("jouer",service.transmettreInfoJoueur("puradosama").getInterets());

        assertEquals("Lucas",service.transmettreInfoJoueur("mana").getPrenom());
        assertEquals("Astier",service.transmettreInfoJoueur("mana").getNom());
        assertEquals(2003,service.transmettreInfoJoueur("mana").getAnneeDeNaissance());
        assertEquals(2,service.transmettreInfoJoueur("mana").getLanguePreferee());
        assertEquals("touhou",service.transmettreInfoJoueur("mana").getInterets());
    }

    @Test
    public void testGestionScoreJoueur() throws PseudoDejaPrisException {
        service.ajouterJoueur("puradosama", "Antoine", "Bouche", 2003,Langue.fra,"jouer");
        service.ajouterJoueur("mana", "Lucas", "Astier", 2003,Langue.fra,"touhou");
        service.gestionScoreJoueur(4,3,"puradosama");
        service.gestionScoreJoueur(2,6,"mana");
        assertEquals(4,service.transmettreInfoJoueur("puradosama").getScores().get(0).getPoints());
        assertEquals(3,service.transmettreInfoJoueur("puradosama").getScores().get(0).getTemps());
        assertEquals(2,service.transmettreInfoJoueur("mana").getScores().get(0).getPoints());
        assertEquals(6,service.transmettreInfoJoueur("mana").getScores().get(0).getTemps());
        service.gestionScoreJoueur(3,5,"puradosama");
        assertEquals(3,service.transmettreInfoJoueur("puradosama").getScores().get(1).getPoints());
        assertEquals(5,service.transmettreInfoJoueur("puradosama").getScores().get(1).getTemps());
    }


}
