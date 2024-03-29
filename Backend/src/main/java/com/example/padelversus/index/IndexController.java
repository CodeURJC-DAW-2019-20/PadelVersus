package com.example.padelversus.index;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchService;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/")
    public String Index(Model model) {
        List<LastMatchDisplay> lastMatches = matchService.lastMatches();
        List<LastMatchDisplay> nextMatches = matchService.nextMatches();

        List<Match> lastMatchesTournament = matchService.getFourLastMatches();
        List<Match> nextMatchesTournament = matchService.getFourNextMatches();

        List<Tournament> tournamentsNext = matchService.findTournamentsOfMatches(nextMatchesTournament);
        List<Tournament> tournamentsLast = matchService.findTournamentsOfMatches(lastMatchesTournament);
        matchService.addNameTournamentOfMatches(lastMatches, tournamentsLast);
        matchService.addNameTournamentOfMatches(nextMatches, tournamentsNext);

        model.addAttribute("last_matches", lastMatches);
        model.addAttribute("next_matches", nextMatches);

        return "index";
    }


}
