package com.example.padelversus.team.display;

import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class TeamsPageDisplayInfo {
    private List<TPTournamentDisplayInfo> tournaments;

    public TeamsPageDisplayInfo(List<Tournament> tournaments){

        for(Tournament t: tournaments){
            this.tournamentsNames.add(t.getName());
            List<String> tTeams = new ArrayList<>();
            for(Team team: t.getTeams()){
                tTeams.add(team.getName());
            }
            this.tournamentTeamsNames.add(tTeams);
        }
    }

    public List<String> getTournamentsNames() {
        return tournamentsNames;
    }

    public void setTournamentsNames(List<String> tournamentsNames) {
        this.tournamentsNames = tournamentsNames;
    }

    public List<List<String>> getTournamentTeamsNames() {
        return tournamentTeamsNames;
    }

    public void setTournamentTeamsNames(List<List<String>> tournamentTeamsNames) {
        this.tournamentTeamsNames = tournamentTeamsNames;
    }
}
