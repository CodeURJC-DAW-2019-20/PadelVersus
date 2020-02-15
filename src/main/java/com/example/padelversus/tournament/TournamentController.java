package com.example.padelversus.tournament;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    TournamentService tournamentService;

    @GetMapping("/")
    public String loadTournaments(Model model) {
        model.addAttribute("tournament-list", tournamentService.getTournaments());
        return "Tournaments";
    }

    @GetMapping("/register")
    public String registerTournamnent(Model model) {
        model.addAttribute("tournamnet-list", tournamentService.getTournaments());
        return "registerTournament";
    }

}

