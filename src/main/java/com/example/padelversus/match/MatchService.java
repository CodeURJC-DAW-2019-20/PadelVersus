package com.example.padelversus.match;

import com.example.padelversus.match.display.MatchesByDateDisplay;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    TournamentRepository tournamentRepository;

    public List<Match> getFourLastMatches() {
        List<Match> matches = matchRepository.findLastFourMatchesPlayedOrderByDateDesc();
        return matches;
    }

    public List<LastMatchDisplay> lastMatches() {
        List<Match> matches = getFourLastMatches();
        List<LastMatchDisplay> lastMatches = new ArrayList<>();
        for (Match match : matches) {
            LastMatchDisplay lastMatchDisplay = new LastMatchDisplay(match);
            lastMatches.add(lastMatchDisplay);

        }

        return lastMatches;
    }

    public List<Match> getFourNextMatches() {
        List<Match> matches = matchRepository.findNextFourMatchesPlayedOrderByDate();
        return matches;
    }

    public List<LastMatchDisplay> nextMatches() {
        List<Match> matches = getFourNextMatches();
        List<LastMatchDisplay> nextMatches = new ArrayList<>();
        for (Match match : matches) {
            LastMatchDisplay lastMatchDisplay = new LastMatchDisplay(match);
            nextMatches.add(lastMatchDisplay);

        }

        return nextMatches;
    }


    public List<Tournament> findTournamentsOfMatches(List<Match> matches) {
        List<Tournament> tournamentsFounds = new ArrayList<>();
        for (Match match : matches) {
            Optional<Tournament> t = tournamentRepository.findTournamentByMatchId(match.getId());
            if (t.isPresent()) {
                tournamentsFounds.add(t.get());
            }
        }
        return tournamentsFounds;
    }

    public void addNameTournamentOfMatches(List<LastMatchDisplay> matchDisplays, List<Tournament> tournaments) {
        int counter = 0;
        for (LastMatchDisplay lastMatchDisplay1 : matchDisplays) {
            lastMatchDisplay1.setTournamentName(tournaments.get(counter).getName());
            counter++;

        }

    }

    public List<MatchesByDateDisplay> getMatchesByDateDisplays() {
        List<MatchesByDateDisplay> matchesByDateDisplays = new ArrayList<>();
        List<Date> datesSQL = matchRepository.findAllDates();
        List<LocalDate> dates = datesSQL.stream().map(Date::toLocalDate).collect(Collectors.toList());
        for (LocalDate date : dates) {
            List<Match> matchOnDateOrdered = matchRepository.findMatchByDateAndPlayedOrderByDate(date, false);
            if (!matchOnDateOrdered.isEmpty()) {
                List<LastMatchDisplay> lastMatchDisplays = new ArrayList<>();
                for (Match match : matchOnDateOrdered) {
                    LastMatchDisplay lastMatchDisplay = new LastMatchDisplay(match);
                    lastMatchDisplays.add(lastMatchDisplay);
                }
                MatchesByDateDisplay matchesByDateDisplay = new MatchesByDateDisplay(lastMatchDisplays, date);
                matchesByDateDisplays.add(matchesByDateDisplay);
            }
        }
        return matchesByDateDisplays;
    }

    public LocalDate getFirstDate() {
        LocalDate firstDate = matchRepository.findAllDates().get(0).toLocalDate();
        return firstDate;
    }
}




