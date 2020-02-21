package com.example.padelversus.match;

import com.example.padelversus.match.display.MatchesByDateDisplay;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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


    public List<Match> getAllNextMatches(){
        List<Match> matches = matchRepository.findAll();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        for (Match match : matches) {

            if(!match.isPlayed())
                matchesOrdered.add(match);
        }
        List<Match>matchesOrderedList = new ArrayList<>();

        for(Match match1:matchesOrdered){
            matchesOrderedList.add(match1);
        }
        return matchesOrderedList;
    }

    public List<LastMatchDisplay> matchesNextMatchDisplays() {
        List<Match> matches = getAllNextMatches();
        List<LastMatchDisplay> matchDisplays = new ArrayList<>();
        for (Match match : matches) {
            LastMatchDisplay  lastMatchDisplay = new LastMatchDisplay(match);
            matchDisplays.add(lastMatchDisplay);

        }
        return matchDisplays;
    }

    public List<LocalDate> datesMatchesNextMatchDisplays() {
        List<LocalDate> dates = new ArrayList<>();
        List<Match> matches = getAllNextMatches();
        for (Match match : matches) {
            dates.add(match.getDate());
        }
        return dates;
    }


    public List<LastMatchDisplay> findNextMatchesWithDate(){
        List<LocalDate> localDates = datesMatchesNextMatchDisplays();
        List<LastMatchDisplay> matchesFounds = new ArrayList<>();
        List<LastMatchDisplay> allMatches = matchesNextMatchDisplays();
        for(LocalDate localDate1:localDates){
            for(LastMatchDisplay lastMatchDisplay:allMatches){
                if(localDate1 == lastMatchDisplay.getLocalDate()){
                    matchesFounds.add(lastMatchDisplay);

                }
            }
        }

        return matchesFounds;
    }

    public List<LastMatchDisplay> findNextMatchesWithDate(LocalDate localDate){
        List<LastMatchDisplay> matchesFounds = new ArrayList<>();
        List<LastMatchDisplay> allMatches = matchesNextMatchDisplays();
        for(LastMatchDisplay lastMatchDisplay:allMatches){
            if(localDate == lastMatchDisplay.getLocalDate()){
                    matchesFounds.add(lastMatchDisplay);
            }
        }
        return matchesFounds;
    }

    public List<MatchesByDateDisplay> formMatchesByDateDisplays(){
        List<MatchesByDateDisplay> matchesByDateDisplaysFounds = new ArrayList<>();
        List<LocalDate> localDates = datesMatchesNextMatchDisplays();
        for(LocalDate localDate:localDates){
                List<LastMatchDisplay> matchesFoundsByDate = findNextMatchesWithDate(localDate);
                MatchesByDateDisplay  matchByDateDisplay = new MatchesByDateDisplay(matchesFoundsByDate,localDate);
                matchesByDateDisplaysFounds.add(matchByDateDisplay);
        }
        return matchesByDateDisplaysFounds;
    }


}




