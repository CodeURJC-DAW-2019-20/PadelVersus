package com.example.padelversus.team.display;

import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class TPTournamentDisplayInfo {

    private String cleanName; //Name without spaces
    private String tournamentName;
    private List<String> teamNames;

    public TPTournamentDisplayInfo(Tournament tournament){
        this.teamNames = new ArrayList<>();
        this.tournamentName = tournament.getName();
        this.cleanName = tournamentName.replaceAll("\\s","");
        for(Team t: tournament.getTeams()) {
            teamNames.add(t.getName());
        }
    }

    public TPTournamentDisplayInfo(List<String> teamNames){
        this.teamNames = teamNames;
        this.tournamentName = "All";
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public List<String> getTeamNames() {
        return teamNames;
    }

    public void setTeamNames(List<String> teamNames) {
        this.teamNames = teamNames;
    }

}
