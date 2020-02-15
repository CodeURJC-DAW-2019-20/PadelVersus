package com.example.padelversus.team;


import com.example.padelversus.team.display.TeamsPageDisplayInfo;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
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

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("")
    public String teams(Model model){
        List<Team> allTeams = teamRepository.findAll();
        List<String> allTeamNames = new ArrayList<>();

        for(Team t: allTeams){
            allTeamNames.add(t.getName());
        }

        List<Tournament> tournamentsList = tournamentRepository.findAll();

        TeamsPageDisplayInfo teamsPageDisplayInfo = new TeamsPageDisplayInfo(tournamentsList);

        model.addAttribute("allTeamNames", allTeamNames);
        model.addAttribute("tournamentNames", teamsPageDisplayInfo.getTournamentsNames());
        model.addAttribute("tournamentTeamNames", teamsPageDisplayInfo.getTournamentTeamsNames());

        return "teams";
    }
}
