package com.example.padelversus.team;


import com.example.padelversus.ImageService;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.display.TeamxDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/teamx")
public class  TeamxController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public String teamx(Model model, @PathVariable Long id) throws IOException {
        Optional<Team> team = teamService.getTeam(id);
        if(team.isPresent()){
            TeamxDisplay teamxDisplay = teamService.createTeamxDisplay(team.get());
            model.addAttribute("teamInfo", teamxDisplay);
            return "teamx";
        }else{
            return "404";

        }
    }
}
