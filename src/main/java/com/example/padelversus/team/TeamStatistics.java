package com.example.padelversus.team;

import javax.persistence.*;

@Entity
public class TeamStatistics {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private int wins;
    private int defeats;


    public TeamStatistics(){

    }

    public TeamStatistics(int wins, int defeats) {
        super();

        this.wins = wins;
        this.defeats = defeats;
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
}
