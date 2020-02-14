package com.example.padelversus.team;

import javax.persistence.*;

@Entity
public class TeamStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private int totalWins;
    private int totalDefeats;
    private int totalAcurracy;
    private int totalEffectiveness;
    private int totalGamesWon;
    private int totalUnforcedErrors;

    public TeamStatistics() {
        super();
        this.totalWins = 0;
        this.totalDefeats = 0;
        this.totalAcurracy = 0;
        this.totalEffectiveness = 0;
        this.totalGamesWon = 0;
        this.totalUnforcedErrors = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalDefeats() {
        return totalDefeats;
    }

    public void setTotalDefeats(int totalDefeats) {
        this.totalDefeats = totalDefeats;
    }

    public int getTotalAcurracy() {
        return totalAcurracy;
    }

    public void setTotalAcurracy(int totalAcurracy) {
        this.totalAcurracy = totalAcurracy;
    }

    public int getTotalEffectiveness() {
        return totalEffectiveness;
    }

    public void setTotalEffectiveness(int totalEffectiveness) {
        this.totalEffectiveness = totalEffectiveness;
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon(int totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    public int getTotalUnforcedErrors() {
        return totalUnforcedErrors;
    }

    public void setTotalUnforcedErrors(int totalUnforcedErrors) {
        this.totalUnforcedErrors = totalUnforcedErrors;
    }


}
