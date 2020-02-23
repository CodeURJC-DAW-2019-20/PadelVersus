package com.example.padelversus.team.teamstatistics;

import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.team.teamstatistics.game.Game;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalGames;
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
        this.totalGames = 0;
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

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
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

    public void resetStatistics(){
        this.totalGames = 0;
        this.totalWins = 0;
        this.totalDefeats = 0;
        this.totalAcurracy = 0;
        this.totalEffectiveness = 0;
        this.totalGamesWon = 0;
        this.totalUnforcedErrors = 0;
        this.gamesPerMatch = new ArrayList<>();
    }

    public void updateStatistics(MatchStadistics lastMatch){
        totalGames++;
        if(lastMatch.isWin()){
            totalWins++;
        }else{
            totalDefeats++;
        }
        totalAcurracy += lastMatch.getAcurracy();
        totalEffectiveness += lastMatch.getEffectiveness();
        totalGamesWon += lastMatch.getGames_wins();
        gamesPerMatch.add(new Game(lastMatch.getGames_wins()));
        totalUnforcedErrors += lastMatch.getUnforcedErrors();
    }

    public String[] meanStatisticsParsed(){
        String[] means = new String[6];
        if(totalGames > 0) {
            means[0] = Integer.toString(totalWins);
            means[1] = Integer.toString(totalDefeats);
            means[2] = Float.toString(totalAcurracy / totalGames);
            means[3] = Float.toString(totalEffectiveness / totalGames);
            means[4] = Float.toString(totalUnforcedErrors / totalGames);
            StringBuilder sb = new StringBuilder();
            int n = gamesPerMatch.size()-1;
            //System.out.println(n);
            for (Game g : gamesPerMatch) {
                sb.append(g.getGames() + "|");
                n--;
                //System.out.println(g.getGames());
            }
            means[5] = sb.toString();
        }else{
            means[0] = "0";
            means[1] = "0";
            means[2] = "0";
            means[3] = "0";
            means[4] = "0";
            means[5] = "0";
        }

        return means;
    }
}
