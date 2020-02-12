package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {
    public List<Team> getTeams(Tournament tournament){
        List<Match> matches = tournament.getMatches();
        List<Team> teams = new ArrayList<>();
        for (Match match : matches) {
            teams.addAll(match.getTeams());
        }
        return teams;
    }
}
