package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    //Returns all team from a tournament oredered by games won(order is archived by insertion)
    ArrayList<Team> teamOrder(Tournament tournament) {
        List<Team> tournamentTeams = tournament.getTeams();
        ArrayList<Team> teamOrder = new ArrayList<>();
        Team mostWin = null;
        int wonMost = Integer.MIN_VALUE;
        while(!tournamentTeams.isEmpty()){
            for (Team onCheckTeam : tournamentTeams) {
                int gamesWon = wonGames(tournament, onCheckTeam);
                if(gamesWon > wonMost){
                    mostWin = onCheckTeam;
                    wonMost = gamesWon;
                }
            }
            tournamentTeams.remove(mostWin);
            wonMost = Integer.MIN_VALUE;
            teamOrder.add(mostWin);
        }
        return teamOrder;
    }

    // Returns the number of matches won for a specific team
    int wonGames(Tournament tournament, Team team) {
        int won = 0;
        List<Match> matches = tournament.getMatches();
        for (Match match : matches) {
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if (index_team == 0) {
                if (match.getStadistics_1().isWin()) won++;
            } else if (index_team == 1) {
                if (match.getStadistics_2().isWin()) won++;
            }
        }
        return won;
    }
}
