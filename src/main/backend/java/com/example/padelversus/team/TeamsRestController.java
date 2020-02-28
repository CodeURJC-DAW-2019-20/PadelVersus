package com.example.padelversus.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamsRestController {
    @Autowired
    TeamService teamService;

    @GetMapping("/teams/")
    public List<String[]> returnAllTeams(Pageable page) {
        Page<Team> pages = teamService.getPages(page);
        List<String[]> pageTeamNames = teamService.getPageTeamNames(pages);
        return pageTeamNames;
    }
}