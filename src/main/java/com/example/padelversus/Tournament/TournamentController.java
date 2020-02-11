package com.example.padelversus.Tournament;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/Tournament")
    public String loadTournament(Model model){
        return "tournaments";
    }
}
