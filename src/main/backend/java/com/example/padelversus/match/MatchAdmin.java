package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Basic;
import java.time.LocalDate;


public class MatchAdmin {

    @JsonView(Basic.class)
    private String name;

    public MatchAdmin() {

    }

    public MatchAdmin(Team t1, Team t2, LocalDate date, Tournament tournament) {
        this.name = date.toString() + "," + t1.getName() + "," + t2.getName() + "," + tournament.getName();

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
}
