package fr.univ_orleans.iut45.mud;

import java.util.HashMap;
import java.util.Map;

public abstract class EpreuveInd implements Epreuve<Athlete>{
    
    protected String nom;
    protected Map<Athlete, Integer> scores;
    protected CompetInd competition;

    public EpreuveInd(String nom){
        this.nom=nom;
        this.scores = new HashMap<>();
    }

    public abstract boolean verifSexe(Athlete athlete);

    @Override
    public Integer getScore(Athlete athlete){
        return this.scores.get(athlete);
    }

    @Override
    public void setScore(Athlete athlete, Integer valeur){
        if(this.verifSexe(athlete) & this.competition.getParticipant().contains(athlete)){
            this.scores.put(athlete, valeur);
        }
    }

    @Override
    public String getNom(){
        return this.nom;
    }

    @Override
    public Integer getScoreTheorique(Athlete athlete){
        return athlete.getAgilite()+athlete.getEndurance()+athlete.getForce();
    }

    @Override
    public String classementEpreuve(){
        return "";
    }



}
