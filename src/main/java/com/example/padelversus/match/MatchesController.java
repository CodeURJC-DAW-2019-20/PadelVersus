package com.example.padelversus.match;

import com.example.padelversus.match.display.MatchesByDateDisplay;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.display.LastMatchDisplay;
import com.example.padelversus.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/matches")
public class MatchesController {

        @Autowired
        private MatchService matchService;

        @GetMapping("/")
        public String matches(Model model){
            List<LastMatchDisplay> lastMatches = matchService.lastMatches();
            List<LastMatchDisplay> nextMatches = matchService.nextMatches();

            List<Match> lastMatchesTournament = matchService.getFourLastMatches();
            List<Match> nextMatchesTournament = matchService.getFourNextMatches();


            List<Tournament> tournamentsNext = matchService.findTournamentsOfMatches(nextMatchesTournament);
            List<Tournament> tournamentsLast = matchService.findTournamentsOfMatches(lastMatchesTournament);
            matchService.addNameTournamentOfMatches(lastMatches,tournamentsLast);
            matchService.addNameTournamentOfMatches(nextMatches,tournamentsNext);


            List<LocalDate> dates = matchService.datesMatchesNextMatchDisplays();
            List<LastMatchDisplay> allNextMatches = matchService.findNextMatchesWithDate();

            model.addAttribute("last_matches", lastMatches);
            model.addAttribute("next_matches",nextMatches);

            //model.addAttribute("list_dates",dates);
            //model.addAttribute("all_matches",allNextMatches)
            List<MatchesByDateDisplay> matchesByDateDisplays = matchService.formMatchesByDateDisplays();
            model.addAttribute("list_matches_byDate",matchesByDateDisplays);



            return "matches";

        }

}
