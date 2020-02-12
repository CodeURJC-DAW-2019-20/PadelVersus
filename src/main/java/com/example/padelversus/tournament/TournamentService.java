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
    // Returns the teams that are into one tournament (no duplicates)
    Set<Team> getTeams(Tournament tournament){
        List<Match> matches = tournament.getMatches();
        Set<Team> teams = new HashSet<>();
        for (Match match : matches) {
            teams.addAll(match.getTeams());
        }
        return teams;
    }

    // Returns the number of matches won for a specific team
    int wonGames(Tournament tournament, Team team){
        int won = 0;
        List<Match> matches = tournament.getMatches();
        for (Match match : matches) {
            List<Team>
        }
        return won;
    }
}
