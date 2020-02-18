package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;

import java.time.LocalDate;
import java.util.Date;

public class MatchAdmin {


    private Team t1;
    private Team t2;
    private LocalDate date;
    private Tournament tournament;
    private String name;
    public MatchAdmin(){

    }
  
    public MatchAdmin(Team t1,Team t2, LocalDate date, Tournament tournament){
        this.name = date.toString() +","+t1.getName()+","+t2.getName()+","+tournament.getName();

    }

    public Team getT1() {
        return t1;
    }

    public void setT1(Team t1) {
        this.t1 = t1;
    }

    public Team getT2() {
        return t2;
    }

    public void setT2(Team t2) {
        this.t2 = t2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
