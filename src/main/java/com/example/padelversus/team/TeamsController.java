package com.example.padelversus.team;


import com.example.padelversus.team.display.TPTournamentDisplayInfo;
import com.example.padelversus.team.display.TeamsPageDisplayInfo;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/")
    public String teams(Model model,Pageable page){
        Page<Team> pages = teamRepository.findAll(page);
        System.out.println(page.getPageSize());
        List<Team> allTeams = teamRepository.findAll();
        List<String> pageTeamNames = new ArrayList<>();
        for(Team t: pages){
            pageTeamNames.add(t.getName());
        }
        List<Tournament> tournamentsList = tournamentRepository.findAll();
        TeamsPageDisplayInfo teamsPageDisplayInfo = new TeamsPageDisplayInfo(tournamentsList, pageTeamNames);
        model.addAttribute("Next",pages.getNumber()+1);
        model.addAttribute("Last",pages.getNumber()-1);
        model.addAttribute("showNext",!pages.isLast());
        model.addAttribute("showPrev",!pages.isFirst());
        model.addAttribute("allTournamentsInfo", teamsPageDisplayInfo.getTournamentDisplays());

        return "teams";
    }
}
