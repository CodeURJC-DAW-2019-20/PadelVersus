package com.example.padelversus.team.display;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.Stadistics.SetPadel;

import java.time.LocalDate;
import java.util.List;

public class LastMatchDisplay {

    private String gamesPerSetOne;
    private String gamesPerSetTwo;
    private String nameTeamOne;
    private String nameTeamTwo;
    private boolean winsTeamOne;
    private String tournamentName;
    private LocalDate localDate;


    public LastMatchDisplay(Match match){

        this.nameTeamOne = match.getTeams().get(0).getName();
        this.nameTeamTwo = match.getTeams().get(1).getName();
        if(match.getStadistics_1() != null || match.getStadistics_2() != null){
                if(match.getStadistics_1().isWin()){
                    this.winsTeamOne = true;
                }else{
                    this.winsTeamOne = false;
            }
            List<SetPadel> setsOne = match.getStadistics_1().getSets();
            List<SetPadel> setsTwo = match.getStadistics_2().getSets();

            StringBuilder sbuilder = new StringBuilder();
            for(SetPadel s: setsOne){
                sbuilder.append(s.getGames());
                sbuilder.append(" ");
            }
            this.gamesPerSetOne = sbuilder.toString();

            StringBuilder sbuilder2 = new StringBuilder();
            for(SetPadel s: setsTwo){
                sbuilder2.append(s.getGames());
                sbuilder2.append(" ");
            }
            this.gamesPerSetTwo = sbuilder2.toString();
        }
        LocalDate date = match.getDate();
        this.localDate = date;



    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getGamesPerSetOne() {
        return gamesPerSetOne;
    }

    public void setGamesPerSetOne(String gamesPerSetOne) {
        this.gamesPerSetOne = gamesPerSetOne;
    }

    public void setGamesPerSetTwo(String gamesPerSetTwo) {
        this.gamesPerSetTwo = gamesPerSetTwo;
    }

    public String getGamesPerSetTwo() {
        return gamesPerSetTwo;
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
