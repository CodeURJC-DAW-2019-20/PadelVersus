package com.example.padelversus.match;

import com.example.padelversus.match.display.MatchesByDateDisplay;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/")
    public String matches(Model model) {
        List<LastMatchDisplay> lastMatches = matchService.lastMatches();

        List<Match> lastMatchesTournament = matchService.getFourLastMatches();


        List<Tournament> tournamentsLast = matchService.findTournamentsOfMatches(lastMatchesTournament);
        matchService.addNameTournamentOfMatches(lastMatches, tournamentsLast);

        model.addAttribute("last_matches", lastMatches);

        List<MatchesByDateDisplay> lastMatchDisplays = matchService.getMatchesByDateDisplays();
        model.addAttribute("list_matches_byDate", lastMatchDisplays);

        LocalDate firstDate = matchService.getFirstDate();
        model.addAttribute("first_date", firstDate);

        return "matches";

    }

}
