package com.example.padelversus.team.display;

import com.example.padelversus.player.Player;
import com.example.padelversus.team.Team;

import java.util.List;

public class TeamxDisplay {
    private final int LAST_MATCHES_SHOWN = 4;
    private String teamName;
    private List<Player> players;
    private List<LastMatchDisplay> lastMatches;

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

    public int getLAST_MATCHES_SHOWN() {
        return LAST_MATCHES_SHOWN;
    }

    public List<LastMatchDisplay> getLastMatches() {
        return lastMatches;
    }

    public void setLastMatches(List<LastMatchDisplay> lastMatches) {
        this.lastMatches = lastMatches;
    }
}
