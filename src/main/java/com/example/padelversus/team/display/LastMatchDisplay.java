package com.example.padelversus.team.display;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.Stadistics.SetPadel;

import java.util.ArrayList;
import java.util.List;

public class LastMatchDisplay {

    private List<Integer> gamesPerSetOne;
    private List<Integer> gamesPerSetTwo;
    private String nameTeamOne;
    private String nameTeamTwo;

    public LastMatchDisplay(Match match){
        this.gamesPerSetOne = new ArrayList<>();
        this.gamesPerSetTwo = new ArrayList<>();
        this.nameTeamOne = match.getTeams().get(0).getName();
        this.nameTeamTwo = match.getTeams().get(1).getName();

        List<SetPadel> setsOne = match.getStadistics_1().getSets();
        List<SetPadel> setsTwo = match.getStadistics_2().getSets();

        for(SetPadel s: setsOne){
            gamesPerSetOne.add(s.getGames());
        }

        for(SetPadel s: setsTwo){
            gamesPerSetTwo.add(s.getGames());
        }
    }



}
