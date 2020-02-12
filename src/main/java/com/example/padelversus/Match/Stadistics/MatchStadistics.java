package com.example.padelversus.Match.Stadistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchStadistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int acurracy;
    private int effectiveness;
    private int games_wins;
    private int unforcedErrors;

    public MatchStadistics() {
    }
    public MatchStadistics(int acurracy,int effectiveness,int wins,int unforcedErrors) {
        super();
        this.acurracy=acurracy;
        this.effectiveness=effectiveness;
        this.unforcedErrors=unforcedErrors;
        this.games_wins=wins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAcurracy() {
        return acurracy;
    }

    public void setAcurracy(int acurracy) {
        this.acurracy = acurracy;
    }

    public int getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness = effectiveness;
    }

    public int getGames_wins() {
        return games_wins;
    }

    public void setGames_wins(int games_wins) {
        this.games_wins = games_wins;
    }

    public int getUnforcedErrors() {
        return unforcedErrors;
    }

    public void setUnforcedErrors(int unforcedErrors) {
        this.unforcedErrors = unforcedErrors;
    }
}
