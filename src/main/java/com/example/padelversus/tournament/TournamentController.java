package com.example.padelversus.tournament;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public String loadTournament(Model model){
        return "Tournaments";
    }

}
