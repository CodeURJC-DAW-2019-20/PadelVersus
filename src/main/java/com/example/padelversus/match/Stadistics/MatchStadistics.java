package com.example.padelversus.match.Stadistics;

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
    private boolean win;

    @Override
    public String toString() {
        return "MatchStadistics{" +
                "id=" + id +
                ", acurracy=" + acurracy +
                ", effectiveness=" + effectiveness +
                ", games_wins=" + games_wins +
                ", unforcedErrors=" + unforcedErrors +
                ", win=" + win +
                '}';
    }

    public MatchStadistics() {
    }
    public MatchStadistics(int acurracy,int effectiveness,int wins,int unforcedErrors,boolean win) {
        super();
        this.acurracy=acurracy;
        this.effectiveness=effectiveness;
        this.unforcedErrors=unforcedErrors;
        this.games_wins=wins;
        this.win=win;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
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
