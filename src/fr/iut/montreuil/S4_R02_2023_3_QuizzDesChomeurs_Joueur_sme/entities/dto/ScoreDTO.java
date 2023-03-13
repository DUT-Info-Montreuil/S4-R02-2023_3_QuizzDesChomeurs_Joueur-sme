package fr.iut.montreuil.S4_R02_2023_3_QuizzDesChomeurs_Joueur_sme.entities.dto;

public class ScoreDTO {

    private int points;
    private int temps;

    public ScoreDTO(int points, int temps){
        this.points = points;
        this.temps = temps;
    }

    public int getPoints() {
        return points;
    }

    public int getTemps() {
        return temps;
    }

}
