package com.example.padelversus.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getFourLastMatches(){
        List<Match> matches = matchRepository.findAll();
        TreeSet<Match> matchesOrdered = new TreeSet<>(Comparator.comparing(Match::getDate));
        matchesOrdered.addAll(matches);
        matches.clear();
        for (int i = 0; i < 4; i++) {
            matches.add(matchesOrdered.pollFirst());
        }
        return matches;
    }
}
