package com.example.padelversus.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
            model.addAttribute("team_1", match.get().getTeam_1());
            model.addAttribute("team_2", match.get().getTeam_2());
            model.addAttribute("score", match.get().getScore());
            model.addAttribute("winner", match.get().getWinner());
            model.addAttribute("date", match.get().getDate());
            return "match";
        } else {
            return "404";
        }
    }
}
