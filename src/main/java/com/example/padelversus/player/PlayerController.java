package com.example.padelversus.player;

import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/player")

public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public String player(Model model){
        return "player";
    }



    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id){
        Optional<Player> player = playerRepository.findById(id);
        Optional<User> user = userRepository.findById(id);
        if (player.isPresent() && user.isPresent()) {
            model.addAttribute("name",user.get().getName());
            model.addAttribute("email",user.get().getMail());
            model.addAttribute("country",player.get().getCountryBirth());
            model.addAttribute("age",player.get().getAge());
            model.addAttribute("height", player.get().getHeight());
            model.addAttribute("weight", player.get().getWeight());
            model.addAttribute("strenght", player.get().getStrength());
            model.addAttribute("endurance", player.get().getEndurance());
            model.addAttribute("pace", player.get().getPace());
            model.addAttribute("speed", player.get().getSpeed());
            model.addAttribute("accuaracy", player.get().getAccuaracy());
            model.addAttribute("aceleration", player.get().getAceleration());
            return "player";
        } else {
            return "404";
        }
    }









}
