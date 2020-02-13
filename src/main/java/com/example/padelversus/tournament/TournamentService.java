package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {
    // Returns the number of matches won for a specific team
    int wonGames(Tournament tournament, Team team){
        int won = 0;
        List<Match> matches = tournament.getMatches();
        for (Match match : matches) {
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if(index_team == 0){
                if(match.getStadistics_1().isWin()) won++;
            }else if(index_team == 1){
                if(match.getStadistics_2().isWin()) won++;
            }
        }
        return won;
    }
}
