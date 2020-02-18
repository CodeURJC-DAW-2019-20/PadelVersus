package com.example.padelversus.match;

import com.example.padelversus.team.display.LastMatchDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

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
            lastMatches.add(new LastMatchDisplay(match));
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




}
