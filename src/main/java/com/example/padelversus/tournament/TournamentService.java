package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.display.TournamentDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;

    //Order all team from a tournament by games won
    void teamOrder(Tournament tournament) {
        List<Team> tournamentTeams = tournament.getTeams();
        ArrayList<Team> teamOrder = new ArrayList<>();
        Team mostWin = null;
        int wonMost = Integer.MIN_VALUE;
        while (!tournamentTeams.isEmpty()) {
            for (Team onCheckTeam : tournamentTeams) {
                int gamesWon = wonGames(tournament, onCheckTeam)[0];
                if (gamesWon > wonMost) {
                    mostWin = onCheckTeam;
                    wonMost = gamesWon;
                }
            }
            tournamentTeams.remove(mostWin);
            wonMost = Integer.MIN_VALUE;
            teamOrder.add(mostWin);
        }
        tournament.setTeams(teamOrder);
    }

    // Returns the number of matches won and played for a specific team
    int[] wonGames(Tournament tournament, Team team) {
        int won = 0;
        int played = 0;
        List<Match> matches = tournament.getMatches();
        for (Match match : matches) {
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if (index_team != -1) {
                if (index_team == 0) {
                    if (match.getStadistics_1().isWin()) won++;
                } else if (index_team == 1) {
                    if (match.getStadistics_2().isWin()) won++;
                }
                played++;
            }
        }
        return new int[]{won, played};
    }

    List<String> lastThreeMatches(Tournament tournament, Team team){
        List<String> lastThreeMatchesRepresentation = new ArrayList<>();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        TreeSet<Match> matchesOrderedTeam = new TreeSet<>(Comparator.comparing(Match::getDate));
        matchesOrdered.addAll(tournament.getMatches());
        for (Match match : matchesOrdered) {
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if (index_team != -1) {
                matchesOrderedTeam.add(match);
            }
        }
        for (int i = 0; i < 3; i++) {
            Match match = matchesOrderedTeam.pollFirst();
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if(index_team == 0){
                lastThreeMatchesRepresentation.add(match.getStadistics_1().isWin() ? "w" : "l");
            }else if(index_team == 1){
                lastThreeMatchesRepresentation.add(match.getStadistics_2().isWin() ? "w" : "l");
            }
        }
        return lastThreeMatchesRepresentation;
    }
    // Get all the tournaments already to display
    List<TournamentDisplay> getTournaments(){
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            teamOrder(tournament);
            TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            for (Team team : tournament.getTeams()) {
                int[] wonPlayed = wonGames(tournament, team);
                List<String> lastMatches = lastThreeMatches(tournament, team);
                tournamentDisplay.addTeam(team, wonPlayed[0], wonPlayed[1], lastMatches);
            }
            allTournamentDisplay.add(tournamentDisplay);
        }
        return allTournamentDisplay;
    }
}
