package com.example.padelversus.match;

import com.example.padelversus.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/{id}")
    public String match(Model model, @PathVariable Long id) {
        Optional<Match> match = matchService.findMatchById(id);

        if (match.isPresent()) {
            List<Team> teams = match.get().getTeams();
            List<Integer> nsets = new ArrayList<>();
            List<Integer> gamest1 = new ArrayList<>();
            List<Integer> gamest2 = new ArrayList<>();
            int score_t1 = 0;
            int score_t2 = 0;
            for (int i = 0; i < match.get().getStadistics_1().getSets().size(); i++) {
                nsets.add(i + 1);
                int game_per_set_t1 = match.get().getStadistics_1().getSets().get(i).getGames();
                int game_per_set_t2 = match.get().getStadistics_2().getSets().get(i).getGames();
                gamest1.add(game_per_set_t1);
                gamest2.add(game_per_set_t2);
                if (game_per_set_t1 > game_per_set_t2) {
                    score_t1 += 1;
                } else {
                    score_t2 += 1;
                }
            }


            model.addAttribute("team_1", teams.get(0).getName());
            model.addAttribute("team_2", teams.get(1).getName());
            model.addAttribute("score_t1", score_t1);
            model.addAttribute("score_t2", score_t2);
            //model.addAttribute("number-sets", nsets);
            model.addAttribute("games-t1", gamest1);
            model.addAttribute("games-t2", gamest2);
            //model.addAttribute("id", id);
            model.addAttribute("accuracy_1", match.get().getStadistics_1().getAcurracy());
            model.addAttribute("accuracy_2", match.get().getStadistics_2().getAcurracy());
            model.addAttribute("effectiveness_1", match.get().getStadistics_1().getEffectiveness());
            model.addAttribute("effectiveness_2", match.get().getStadistics_2().getEffectiveness());
            model.addAttribute("wins_1", match.get().getStadistics_1().getGames_wins());
            model.addAttribute("wins_2", match.get().getStadistics_2().getGames_wins());
            model.addAttribute("unferrors_1", match.get().getStadistics_1().getUnforcedErrors());
            model.addAttribute("unferrors_2", match.get().getStadistics_1().getUnforcedErrors());

            //model.addAttribute("date", match.get().getDate());
            return "matchResult";
        } else {
            return "404";
        }
    }
}
