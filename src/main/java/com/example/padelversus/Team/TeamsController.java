package com.example.padelversus.Team;


import com.example.padelversus.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/teams")
public class TeamsController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/")
    public String teams(){
        return "teams";
    }
}
