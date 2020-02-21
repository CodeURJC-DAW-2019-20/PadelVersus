package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchAdmin;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.MatchStadisticsRepository;
import com.example.padelversus.match.Stadistics.SetPadel;
import com.example.padelversus.match.Stadistics.SetPadelRepository;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.tournament.TournamentService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;

@Controller
public class AdminController {
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TournamentService tournamentService;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    SetPadelRepository setPadelRepository;
    @Autowired
    MatchStadisticsRepository matchStadisticsRepository;
    @Autowired
    AdminService adminService;

    @RequestMapping("/adminPage")
    public String adminPage(Model model) {
        /*List<Tournament> allTournament = tournamentRepository.findAll();
        List<MatchAdmin> matchAdmins = new ArrayList<>();

        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            for (Match match : tournament.getMatches()) {
                List<Team> teamList = match.getTeams();
                if (!match.isPlayed()) {
                    MatchAdmin matchAdmin = new MatchAdmin(teamList.get(0), teamList.get(1), match.getDate(), tournament);
                    matchAdmins.add(matchAdmin);
                }
            }
            TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            for (Team team : tournament.getTeams()) {
                List<String> lastMatches = tournamentService.lastThreeMatches(tournament, team);
                boolean hasLastMatches = lastMatches != null;
                tournamentDisplay.addTeam(team, 0, 0, lastMatches, hasLastMatches);
            }
            allTournamentDisplay.add(tournamentDisplay);

        }*/
        List<Object> lista;
        lista = adminService.adminPage();
        List<TournamentDisplay> allTournamentDisplay = (List<TournamentDisplay>) lista.get(0);
        List<MatchAdmin> matchAdmins = (List<MatchAdmin>) lista.get(1);
        model.addAttribute("tournament-list", allTournamentDisplay);
        model.addAttribute("match-list", matchAdmins);
        return "/adminPage";
    }


    @PostMapping("/saveMatch")
    public String savematch(String selectedTournament, String t1_oficial, String t2_oficial, String date) {
        Optional<Tournament> tournament = tournamentRepository.findByName(selectedTournament);

        Team team1 = adminService.getTeam(selectedTournament, t1_oficial);
        Team team2 = adminService.getTeam(selectedTournament, t2_oficial);
        String[] parts = date.split("-");

        Match match = new Match(false, LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), team1, team2);

        matchRepository.save(match);
        team1.addMatch(match);
        team2.addMatch(match);
        teamRepository.save(team1);
        teamRepository.save(team2);
        tournament.get().addMatch(match);
        tournamentRepository.save(tournament.get()); //save the new match in tournament table

        return "/adminPage";
    }

    @PostMapping("/savetournament")
    public String savetournament(String name) {
        Tournament tournament = new Tournament(name);

        tournamentRepository.save(tournament); //save new tournament in tournament table

        return "/adminPage";
    }

    @PostMapping("/saveDataMatch")
    public String saveDatamatch(String matchSelect, String accuracy1, String effectiveness1, String games_wins1, String unforcedErrors1, String set1team1, String set2team1, String set3team1, String win1, String accuracy2, String effectiveness2, String games_wins2, String unforcedErrors2, String set1team2, String set2team2, String set3team2, String win2) {

        String[] match = matchSelect.split(",");
        Optional<Team> team1 = teamRepository.findByName(match[1]);
        Optional<Team> team2 = teamRepository.findByName(match[2]);
        Optional<Tournament> tournament = tournamentRepository.findByName(match[3]);

        Match matchDatabase = adminService.findMatchByTeams(team1.get(), team2.get(), tournament.get());
        if (matchDatabase != null) {
            matchDatabase.setPlayed(true);
            MatchStadistics statsOne = adminService.calculateStats(accuracy1, effectiveness1, games_wins1, unforcedErrors1, set1team1, set2team1, set3team1, win1);
            MatchStadistics statsTwo = adminService.calculateStats(accuracy2, effectiveness2, games_wins2, unforcedErrors2, set1team2, set2team2, set3team2, win2);
            matchDatabase.setStadistics_1(statsOne);
            matchDatabase.setStadistics_2(statsTwo);
            matchRepository.save(matchDatabase);
        }

        return "/adminPage";
    }


}
