package com.example.padelversus.tournament.display;

import com.example.padelversus.team.Team;
import com.example.padelversus.team.display.TeamDisplay;
import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Basic;
import java.util.ArrayList;
import java.util.List;

public class TournamentDisplay {

    interface TeamDisplays{}

    @JsonView(Basic.class)
    private String name;

    @JsonView(Basic.class)
    private String nonspacename;

    @JsonView(TeamDisplays.class)
    private List<TeamDisplay> teams;

    public TournamentDisplay(Tournament tournament) {
        this.name = tournament.getName();
        this.nonspacename = tournament.getNonspacename();
        this.teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNonspacename() {
        return nonspacename;
    }

    public void setNonspacename(String nonspacename) {
        this.nonspacename = nonspacename;
    }

    public List<TeamDisplay> getTeams() {
        return teams;
    }

    public void addTeam(Team team, int gamesWon, int gamesPlayed, List<String> lastMatches, boolean hasLastMatches) {
        TeamDisplay teamDisplay = new TeamDisplay(team.getName(), gamesWon, gamesPlayed, gamesPlayed - gamesWon, lastMatches, hasLastMatches, team.getId());
        this.teams.add(teamDisplay);
    }
}
