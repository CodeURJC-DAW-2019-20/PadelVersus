package com.example.padelversus.team;

import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiTeams")
public class    TeamsRestController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping("/")
    public List<String[]> returnAllTeams(Pageable page){
        Page<Team> pages = teamRepository.findAll(page);
        List<String[]> pageTeamNames = new ArrayList<>();
        for(Team t: pages){
            String[] info = {Long.toString(t.getId()), t.getName()};
            pageTeamNames.add(info);
        }
    return pageTeamNames;
    }
}
