package com.example.padelversus;

import sun.util.resources.Bundles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Team team_1;
    private Team team_2;
    private String score;
    private String date;
    private Team winner;

    public Match() {
    }
    public Match(Team team_1,Team team_2,String score, String Date, Team winner){

    }
}
