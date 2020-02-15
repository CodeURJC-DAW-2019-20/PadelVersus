package com.example.padelversus.team.display;

import com.example.padelversus.tournament.Tournament;

import java.util.ArrayList;
import java.util.List;

public class TeamsPageDisplayInfo {

    private List<TPTournamentDisplayInfo> tournamentDisplays;

    public TeamsPageDisplayInfo(List<Tournament> tournaments){

        this.tournamentDisplays = new ArrayList<>();
        for(Tournament t: tournaments){
            TPTournamentDisplayInfo display = new TPTournamentDisplayInfo(t);
            tournamentDisplays.add(display);
        }
    }

    public List<TPTournamentDisplayInfo> getTournamentDisplays() {
        return tournamentDisplays;
    }

    public void setTournamentDisplays(List<TPTournamentDisplayInfo> tournamentDisplays) {
        this.tournamentDisplays = tournamentDisplays;
    }
}
