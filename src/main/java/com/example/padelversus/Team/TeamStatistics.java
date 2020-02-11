package com.example.padelversus.Team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TeamStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private int wins;
    private int defeats;

    private List<Integer> gamesPerMatch;
    private List<Integer> matches;

    public TeamStatistics(){

    }

    public TeamStatistics(int wins, int defeats, List<Integer> gamesPerMatch, List<Integer> matches) {
        super();

        this.wins = wins;
        this.defeats = defeats;
        this.gamesPerMatch = gamesPerMatch;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public List<Integer> getGamesPerMatch() {
        return gamesPerMatch;
    }

    public void setGamesPerMatch(List<Integer> gamesPerMatch) {
        this.gamesPerMatch = gamesPerMatch;
    }

    public List<Integer> getMatches() {
        return matches;
    }

    public void setMatches(List<Integer> matches) {
        this.matches = matches;
    }
}
