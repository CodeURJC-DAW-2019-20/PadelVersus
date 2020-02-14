package com.example.padelversus.team;

import com.example.padelversus.team.game.Game;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany (cascade = CascadeType.ALL)
    private List<Game> gamesPerMatch;

    public TeamStatistics() {
        super();
        this.totalWins = 0;
        this.totalDefeats = 0;
        this.totalAcurracy = 0;
        this.totalEffectiveness = 0;
        this.totalGamesWon = 0;
        this.totalUnforcedErrors = 0;
        this.gamesPerMatch = new ArrayList<>();
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

    public List<Game> getGamesPerMatch() {
        return gamesPerMatch;
    }

    public void setGamesPerMatch(List<Game> gamesPerMatch) {
        this.gamesPerMatch = gamesPerMatch;
    }

    public void addGame(Game game){
        gamesPerMatch.add(game);
    }
}
