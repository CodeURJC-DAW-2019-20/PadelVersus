package com.example.padelversus.match;

import com.example.padelversus.match.Stadistics.MatchStadistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchRepository matchRepository;


    @GetMapping("/{id}")
    public String match(Model model, @PathVariable Long id){
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()) {
            ArrayList teams= (ArrayList) match.get().getTeams();
            MatchStadistics m1 = match.get().getStadistics_1();
            MatchStadistics m2 = match.get().getStadistics_2();
            model.addAttribute("team_1", teams.get(0));
            model.addAttribute("team_2", teams.get(0));
            model.addAttribute("id",id);
            model.addAttribute("accuracy_1",match.get().getStadistics_1().getAcurracy());
            model.addAttribute("accuracy_2",match.get().getStadistics_2().getAcurracy());
            model.addAttribute("effectiveness_1",match.get().getStadistics_1().getEffectiveness());
            model.addAttribute("effectiveness_2",match.get().getStadistics_2().getEffectiveness());
            model.addAttribute("wins_1",match.get().getStadistics_1().getGames_wins());
            model.addAttribute("wins_2",match.get().getStadistics_2().getGames_wins());
            model.addAttribute("unferrors_1",match.get().getStadistics_1().getUnforcedErrors());
            model.addAttribute("unferrors_2",match.get().getStadistics_1().getUnforcedErrors());
            model.addAttribute("score", match.get().getScore());
            model.addAttribute("date", match.get().getDate());
            return "overviewMatches";
        } else {
            return "404";
        }
    }
}
