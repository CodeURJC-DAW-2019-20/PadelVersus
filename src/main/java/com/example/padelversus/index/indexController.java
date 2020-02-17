package com.example.padelversus.index;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchService;
import com.example.padelversus.team.display.LastMatchDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private MatchService matchService;


    @GetMapping("/")
    public String Index(Model model) {
        List<Match> matches = matchService.getFourLastMatches();
        List<LastMatchDisplay> lastMatches = new ArrayList<>();
        for (Match match : matches) {
            lastMatches.add(new LastMatchDisplay(match));
        }
        model.addAttribute("last_matches", lastMatches);
        return "index";
    }


}
