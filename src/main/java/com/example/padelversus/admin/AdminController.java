package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchAdmin;
import com.example.padelversus.match.MatchService;
import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamService;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    AdminService adminService;

    @Autowired
    TeamService teamService;

    @Autowired
    MatchService matchService;

    @RequestMapping("/adminPage")
    public String adminPage(Model model) {
        List<Object> lista;
        lista = adminService.adminPage();
        List<TournamentDisplay> allTournamentDisplay = (List<TournamentDisplay>) lista.get(0);
        List<MatchAdmin> matchAdmins = (List<MatchAdmin>) lista.get(1);
        model.addAttribute("tournament-list", allTournamentDisplay);
        model.addAttribute("match-list", matchAdmins);
        model.addAttribute("error", false);
        return "/adminPage";
    }

    @PostMapping("/saveMatch")
    public String savematch(String selectedTournament, String t1_oficial, String t2_oficial, String date, Model model) {
        if(t1_oficial.equals(t2_oficial)){
            List<Object> lista;
            lista = adminService.adminPage();
            List<TournamentDisplay> allTournamentDisplay = (List<TournamentDisplay>) lista.get(0);
            List<MatchAdmin> matchAdmins = (List<MatchAdmin>) lista.get(1);
            model.addAttribute("tournament-list", allTournamentDisplay);
            model.addAttribute("match-list", matchAdmins);
            model.addAttribute("error", true);
            return "/adminPage";
        }
        adminService.saveMatch(selectedTournament, t1_oficial, t2_oficial, date);

        return "redirect:/adminPage";
    }

    @PostMapping("/savetournament")
    public String savetournament(String name, Model model) {
        List<Object> lista;
        lista = adminService.adminPage();
        List<TournamentDisplay> allTournamentDisplay = (List<TournamentDisplay>) lista.get(0);
        boolean equal = false;
        for (TournamentDisplay tournamentDisplay : allTournamentDisplay) {
            if(tournamentDisplay.getName().equals(name)){
                equal = true;
            }
        }
        if(equal){
            List<MatchAdmin> matchAdmins = (List<MatchAdmin>) lista.get(1);
            model.addAttribute("tournament-list", allTournamentDisplay);
            model.addAttribute("match-list", matchAdmins);
            model.addAttribute("error", true);
            return "/adminPage";
        }
        Tournament tournament = new Tournament(name);
        tournamentService.saveTournament(tournament);

        return "redirect:/adminPage";
    }

    @PostMapping("/saveDataMatch")
    public String saveDatamatch(String matchSelect,
                                String accuracy1,
                                String effectiveness1,
                                String unforcedErrors1,
                                String set1team1,
                                String set2team1,
                                String set3team1,
                                String win1,
                                String accuracy2,
                                String effectiveness2,
                                String unforcedErrors2,
                                String set1team2,
                                String set2team2,
                                String set3team2,
                                String win2) {

        String[] match = matchSelect.split(",");

        Optional<Team> team1 = teamService.getTeamByName(match[1]);
        Optional<Team> team2 = teamService.getTeamByName(match[2]);
        Optional<Tournament> tournament = tournamentService.getTournamentByName(match[3]);

        Match matchDatabase = adminService.findMatchByTeams(team1.get(), team2.get(), tournament.get());
        if (matchDatabase != null) {
            matchDatabase.setPlayed(true);
            MatchStadistics statsOne = adminService.calculateStats(accuracy1, effectiveness1, "0", unforcedErrors1, set1team1, set2team1, set3team1, win1);
            MatchStadistics statsTwo = adminService.calculateStats(accuracy2, effectiveness2, "0", unforcedErrors2, set1team2, set2team2, set3team2, win2);
            team1.get().updateTeamStatistics(statsOne);
            team2.get().updateTeamStatistics(statsTwo);
            matchDatabase.setStadistics_1(statsOne);
            matchDatabase.setStadistics_2(statsTwo);
            matchService.saveMatch(matchDatabase);
        }

        return "redirect:/adminPage";
    }


}
