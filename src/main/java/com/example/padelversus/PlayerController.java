package com.example.padelversus;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
}
