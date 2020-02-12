package com.example.padelversus.tournament;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public String loadTournament(Model model) {
        System.out.println("Estoy en /tournament");
        Optional<Tournament> tournament = tournamentRepository.getById(1L);
        if (tournament.isPresent()) {
            System.out.println("Torneo encontrado");

        }
        return "Tournaments";
    }

}
