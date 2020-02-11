package com.example.padelversus.Team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            model.addAttribute("teamName", "te");
            model.addAttribute("playerOneName", "Pdro");
            return "teamx";
        }else{
            return "404";
        }
    }
}
