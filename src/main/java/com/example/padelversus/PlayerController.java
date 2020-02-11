package com.example.padelversus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;


    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id){
            Optional<Player> player = playerRepository.findById(id);
            if (player.isPresent()) {
                model.addAttribute("name", player.get().getUsername());
                return "player";
            } else {
                return "404";
            }
    }

    @GetMapping("/teamxtest")
    public String teamx(){
        return "teamx";
    }

    @GetMapping("/overviewtest")
    public String overview(){
        return "overviewMatches";
    }

    @GetMapping("/s")
    public String s(){
        return "standings";
    }
    @GetMapping("/teamstest")
    public String teams(){
        return "teams";
    }

    @GetMapping("/cal")
    public String cal(){
        return "calendar";
    }

    @GetMapping("/rf")
    public String rf(){
        return "RegistrationForm";
    }

    @GetMapping("/matches")
    public String matches(){
        return "matches";
    }

}
