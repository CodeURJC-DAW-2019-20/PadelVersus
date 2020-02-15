package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.tournament.TournamentService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import com.example.padelversus.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TournamentService tournamentService;

    @RequestMapping("/adminPage")
    public String adminPage(Model model){
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            //tournamentService.teamOrder(tournament);
            //TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            model.addAttribute("tournament-teams-"+tournament.getName(),tournament.getTeams());

            // allTournamentDisplay.add(tournamentDisplay);
        }
        model.addAttribute("tournament-list", allTournament);
        //model.addAttribute("tournament-teams",tournament.getTeams());

        return "/adminPage";
    }
    @RequestMapping("/prueba")
    public String prueba(){

        return "/prueba";
    }
    @PostMapping("/saveMatch")
    public String saveuser(Tournament tournament, Match match){
        System.out.println(match.getDate());

        //Match match1 = new Match(date,t1,t2);
        List<Match> matches = (List<Match>) match;
        tournament.setMatches(matches);
        tournamentRepository.save(tournament);
        matchRepository.save(match);
        /*User u = uc.findByName(user.getName());
        if (u == null) {
            uc.save(user);
            //notificationService.sendNotification(user);
            //updateTabs(model);
            return "/signupPlayer";
        }

       // return "404";*/
        return "/adminPage";
    }
}
