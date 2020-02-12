package com.example.padelversus.tournament;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String date;


    //private List<Match> Matches;
    //private Team winner;

    public Tournament() {
    }

    /*public tournament(String name, String date, List<Match> matches, Team winner) {
        this.name = name;
        this.date = date;
        Matches = matches;
        this.winner = winner;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*public List<Match> getMatches() {
        return Matches;
    }

    public void setMatches(List<Match> matches) {
        Matches = matches;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }*/
}
