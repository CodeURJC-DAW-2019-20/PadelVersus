package com.example.padelversus.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamsController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("")
    public String teams(Model model){
        List<Team> allTeams = teamRepository.findAll();
        List<String> teamNames = new ArrayList<>();

        for(Team t: allTeams){
            teamNames.add(t.getName());
        }

        model.addAttribute("teamNames", teamNames);
        return "teams";
    }
}
