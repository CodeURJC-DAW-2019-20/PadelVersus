package com.example.padelversus.team.display;

import com.example.padelversus.player.Player;
import com.example.padelversus.team.Team;

import java.util.List;

public class TeamxDisplay {
    private String teamName;
    private List<Player> players;

    public TeamxDisplay(Team team){
        this.teamName = team.getName();
        this.players = team.getPlayers();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
