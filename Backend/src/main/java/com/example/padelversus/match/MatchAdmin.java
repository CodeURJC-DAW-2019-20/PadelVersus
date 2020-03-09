package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Basic;
import java.time.LocalDate;


public class MatchAdmin {

    @JsonView(Basic.class)
    private String name;

    @JsonView(Basic.class)
    private Team t1;

    @JsonView(Basic.class)
    private Team t2;

    @JsonView(Basic.class)
    private LocalDate date;

    @JsonView(Basic.class)
    private Tournament tournament;

    public MatchAdmin() {

    }

    public MatchAdmin(Team t1, Team t2, LocalDate date, Tournament tournament) {
        this.name = date.toString() + "," + t1.getName() + "," + t2.getName() + "," + tournament.getName();
        this.t1 = t1;
        this.t2 = t2;
        this.date = date;
        this.tournament = tournament;
    }
    public MatchAdmin(Match match, String tournament_name) {
        this.name = match.getDate().toString() +
                "," + match.getTeams().get(0).getName()
                + "," + match.getTeams().get(1).getName()
                + "," + tournament_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
