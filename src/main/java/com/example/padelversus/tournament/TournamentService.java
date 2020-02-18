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
    public void teamOrder(Tournament tournament) {
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
        tournamentRepository.save(tournament);
    }

    // Returns the number of matches won and played for a specific team
    public int[] wonGames(Tournament tournament, Team team) {
        
        int won = 0;
        int played = 0;
        List<Match> matches = tournament.getMatches();
        for (Match match : matches) {
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if (index_team != -1) {
                if (index_team == 0) {
                    if(match.getStadistics_1() != null) {
                        if (match.getStadistics_1().isWin()) won++;
                    }
                } else if (index_team == 1) {
                    if(match.getStadistics_2() != null) {
                        if (match.getStadistics_2().isWin()) won++;
                    }
                }
                played++;
            }
        }
        return new int[]{won, played};
    }

    public List<String> lastThreeMatches(Tournament tournament, Team team){
        
        List<String> lastThreeMatchesRepresentation = new ArrayList<>();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        TreeSet<Match> matchesOrderedTeam = new TreeSet<>(Comparator.comparing(Match::getDate));
        matchesOrdered.addAll(tournament.getMatches());
        if(team.getName().equals("Patata")){
            System.out.println();
        }
        for (Match match : matchesOrdered) {
            if(match.isPlayed()) {
                List<Team> teams_match = match.getTeams();
                int index_team = teams_match.indexOf(team);
                if (index_team != -1) {
                    matchesOrderedTeam.add(match);
                }
            }
        }
        if(matchesOrderedTeam.isEmpty()) return null;
        int max_for = matchesOrderedTeam.size() < 3 ? matchesOrdered.size() : 3;
        for (int i = 0; i < max_for; i++) {
            Match match = matchesOrderedTeam.first();
            List<Team> teams_match = match.getTeams();
            int index_team = teams_match.indexOf(team);
            if(index_team == 0){
                lastThreeMatchesRepresentation.add(match.getStadistics_1().isWin() ? "w" : "l");
            }else if(index_team == 1){
                lastThreeMatchesRepresentation.add(match.getStadistics_2().isWin() ? "w" : "l");
            }
            matchesOrderedTeam.remove(match);
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
                System.out.println("Get tournament: " + tournament.getName() + " " + team.getName());
                int[] wonPlayed = wonGames(tournament, team);
                List<String> lastMatches = lastThreeMatches(tournament, team);
                boolean hasLastMatches = lastMatches != null;
                tournamentDisplay.addTeam(team, wonPlayed[0], wonPlayed[1], lastMatches, hasLastMatches);
            }
            allTournamentDisplay.add(tournamentDisplay);
        }
        return allTournamentDisplay;
    }
}
