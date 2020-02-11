package com.example.padelversus.Player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")

public class PlayerController {

    @GetMapping("/")
    public String player(Model model){
        return "player";
    }



}
