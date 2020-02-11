package com.example.padelversus.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/player")

public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;


    @GetMapping("/")
    public String player(Model model){
        return "player";
    }



    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            model.addAttribute("name",player.get().getUsername());
            model.addAttribute("country",player.get().getPaisNacimiento());
            return "player";
        } else {
            return "404";
        }
    }









}
