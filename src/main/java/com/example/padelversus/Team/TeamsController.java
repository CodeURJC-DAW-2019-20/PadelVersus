package com.example.padelversus.Team;


import com.example.padelversus.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/teams")
public class TeamsController {

    @GetMapping("/")
    public String teams(){
        return "teams";
    }
}
