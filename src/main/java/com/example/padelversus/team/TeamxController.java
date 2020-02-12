package com.example.padelversus.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/teamx")
public class TeamxController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/{id}")
    public String teamx(Model model, @PathVariable Long id){
        Optional<Team> team = teamRepository.findByid(id);
        if(team.isPresent()){

            String teamName = team.get().getName();

            model.addAttribute("teamName", teamName);
            model.addAttribute("playerOneName", "PEPE");
            return "teamx";
        }else{
            return "404";
        }
    }
}
