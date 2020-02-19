package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLOutput;
import java.util.*;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    TournamentRepository tournamentRepository;

    public List<Match> getFourLastMatches(){
        List<Match> matches = matchRepository.findAll();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        for (Match match : matches) {
            if(match.isPlayed()) matchesOrdered.add(match);
        }
        matches.clear();
        for (int i = 0; i < 4; i++) {
            matches.add(matchesOrdered.pollFirst());
        }
        return matches;
    }

    public List<LastMatchDisplay> lastMatches() {
        List<Match> matches = getFourLastMatches();
        List<LastMatchDisplay> lastMatches = new ArrayList<>();
        for (Match match : matches) {
            LastMatchDisplay  lastMatchDisplay = new LastMatchDisplay(match);
            lastMatches.add(lastMatchDisplay);

        }

        return lastMatches;
    }

    public List<Match> getFourNextMatches(){
        List<Match> matches = matchRepository.findAll();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        for (Match match : matches) {

            if(!match.isPlayed())
                matchesOrdered.add(match);
        }
        matches.clear();
        for (int i = 0; i < 4; i++) {
            matches.add(matchesOrdered.pollFirst());
        }


        return matches;
    }

    public List<LastMatchDisplay> nextMatches() {
        List<Match> matches = getFourNextMatches();
        List<LastMatchDisplay> nextMatches = new ArrayList<>();
        for (Match match : matches) {
            LastMatchDisplay  lastMatchDisplay = new LastMatchDisplay(match);
            nextMatches.add(lastMatchDisplay);

        }

        return nextMatches;
    }


    public List<Tournament> findTournamentsOfMatches(List<Match> matches){

        List<Tournament> allTournaments = tournamentRepository.findAll();
        List<Tournament> tournamentsFounds = new ArrayList<>();
        for(Match match:matches){
            for(Tournament tournament:allTournaments){
                if(tournament.getMatches().contains(match)){
                    tournamentsFounds.add(tournament);
                }
            }


        }
        return tournamentsFounds;
    }

    public void addNameTournamentOfMatches(List<LastMatchDisplay> matchDisplays,List<Tournament> tournaments) {
        int counter = 0;
        for (LastMatchDisplay lastMatchDisplay1 : matchDisplays) {
            lastMatchDisplay1.setTournamentName(tournaments.get(counter).getName());
            counter++;
        }

    }

}
