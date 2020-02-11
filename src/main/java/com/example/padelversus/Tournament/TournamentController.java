package com.example.padelversus.Tournament;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentController {

    //@Autowired
    //TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public String loadTournament(Model model){
        return "Tournaments";
    }

}
