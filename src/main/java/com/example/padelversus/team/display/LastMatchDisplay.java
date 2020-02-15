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
    private boolean winsTeamOne;

    public LastMatchDisplay(Match match){

        this.nameTeamOne = match.getTeams().get(0).getName();
        this.nameTeamTwo = match.getTeams().get(1).getName();

        if(match.getStadistics_1().isWin()){
            this.winsTeamOne = true;
        }else{
            this.winsTeamOne = false;
        }


        this.gamesPerSetOne = new ArrayList<>();
        this.gamesPerSetTwo = new ArrayList<>();
        List<SetPadel> setsOne = match.getStadistics_1().getSets();
        List<SetPadel> setsTwo = match.getStadistics_2().getSets();

        for(SetPadel s: setsOne){
            gamesPerSetOne.add(s.getGames());
        }

        for(SetPadel s: setsTwo){
            gamesPerSetTwo.add(s.getGames());
        }
    }

    public List<Integer> getGamesPerSetOne() {
        return gamesPerSetOne;
    }

    public void setGamesPerSetOne(List<Integer> gamesPerSetOne) {
        this.gamesPerSetOne = gamesPerSetOne;
    }

    public List<Integer> getGamesPerSetTwo() {
        return gamesPerSetTwo;
    }

    public void setGamesPerSetTwo(List<Integer> gamesPerSetTwo) {
        this.gamesPerSetTwo = gamesPerSetTwo;
    }

    public String getNameTeamOne() {
        return nameTeamOne;
    }

    public void setNameTeamOne(String nameTeamOne) {
        this.nameTeamOne = nameTeamOne;
    }

    public String getNameTeamTwo() {
        return nameTeamTwo;
    }

    public void setNameTeamTwo(String nameTeamTwo) {
        this.nameTeamTwo = nameTeamTwo;
    }

    public boolean isWinsTeamOne() {
        return winsTeamOne;
    }

    public void setWinsTeamOne(boolean winsTeamOne) {
        this.winsTeamOne = winsTeamOne;
    }
}
