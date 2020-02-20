package com.example.padelversus.team.display;

import com.example.padelversus.ImageService;
import com.example.padelversus.match.Match;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamxDisplay {
    private final int LAST_MATCHES_SHOWN = 4;
    private String teamName;
    private List<Player> players;
    private List<LastMatchDisplay> lastMatches;
    private TeamStatisticsDisplay statisticsDisplay;

    public TeamxDisplay(Team team){
        this.teamName = team.getName();
        this.players = team.getPlayers();

        this.lastMatches = new ArrayList<>();
        List<Match> matches = team.getLastNMatches(LAST_MATCHES_SHOWN);
        for(Match m : matches){
            if(m.isPlayed()){
                lastMatches.add(new LastMatchDisplay(m));
            }
        }

        this.statisticsDisplay = new TeamStatisticsDisplay(team.getTeamStatistics());
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

    public TeamStatisticsDisplay getStatisticsDisplay() {
        return statisticsDisplay;
    }

    public void setStatisticsDisplay(TeamStatisticsDisplay statisticsDisplay) {
        this.statisticsDisplay = statisticsDisplay;
    }
}
