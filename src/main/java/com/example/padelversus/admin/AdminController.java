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

    @RequestMapping("/adminPage")
    public String adminPage(Model model) {
        List<Tournament> allTournament = tournamentRepository.findAll();
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

        }

        model.addAttribute("tournament-list", allTournamentDisplay);
        model.addAttribute("match-list", matchAdmins);
        return "/adminPage";
    }

    @RequestMapping("/prueba")
    public String prueba() {

        return "/prueba";
    }

    @PostMapping("/saveMatch")
    public String savematch(String torneoSeleccionado, String t1_oficial, String t2_oficial, String date) {
        Optional<Tournament> tournament = tournamentRepository.findByName(torneoSeleccionado);
        String[] teamName1 = t1_oficial.split(",");
        String[] teamName2 = t2_oficial.split(",");
        Team team1 = new Team();
        for (String s : teamName1) {
            Optional<Team> teamaux = teamRepository.findByName(s);
            if (teamaux.isPresent()) {
                if (tournament.get().hasTeam(teamaux.get())) {
                    team1 = teamaux.get();
                }
            }
        }
        Team team2 = new Team();
        for (String s : teamName2) {
            Optional<Team> teamaux = teamRepository.findByName(s);
            if (teamaux.isPresent()) {
                if (tournament.get().hasTeam(teamaux.get())) {
                    team2 = teamaux.get();
                }
            }
        }
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

        Match matchDatabase = findMatchByTeams(team1.get(), team2.get(), tournament.get());
        if (matchDatabase != null) {
            matchDatabase.setPlayed(true);

            int auxAccuracy = Integer.parseInt(accuracy1);
            int auxEffect = Integer.parseInt(effectiveness1);
            int auxGamesWin = Integer.parseInt(games_wins1);
            int auxUnforcedError = Integer.parseInt(unforcedErrors1);
            int auxSet1 = Integer.parseInt(set1team1);
            int auxSet2 = Integer.parseInt(set2team1);
            int auxSet3 = Integer.parseInt(set3team1);
            boolean auxWin = Boolean.parseBoolean(win1);

            List<SetPadel> auxSets1 = new ArrayList<>();
            SetPadel firstSet = new SetPadel(auxSet1, 1);
            SetPadel secondSet = new SetPadel(auxSet2, 2);
            auxSets1.add(firstSet);
            auxSets1.add(secondSet);
            if (auxSet3 != -1) {
                SetPadel thirdSet = new SetPadel(auxSet3, 3);
                auxSets1.add(thirdSet);
            }
            MatchStadistics statsOne = new MatchStadistics(auxSets1, auxAccuracy, auxEffect, auxGamesWin, auxUnforcedError, auxWin);
            System.out.println("MATCH STADISTICS 1:" + statsOne.toString());
            auxAccuracy = Integer.parseInt(accuracy2);
            auxEffect = Integer.parseInt(effectiveness2);
            auxGamesWin = Integer.parseInt(games_wins2);
            auxUnforcedError = Integer.parseInt(unforcedErrors2);
            auxSet1 = Integer.parseInt(set1team2);
            auxSet2 = Integer.parseInt(set2team2);
            auxSet3 = Integer.parseInt(set3team2);
            auxWin = Boolean.parseBoolean(win2);
            List<SetPadel> auxSets2 = new ArrayList<>();
            SetPadel firstSet2 = new SetPadel(auxSet1, 1);
            SetPadel secondSet2 = new SetPadel(auxSet2, 2);
            auxSets2.add(firstSet2);
            auxSets2.add(secondSet2);

            if (auxSet3 != -1) {
                SetPadel thirdSet2 = new SetPadel(auxSet3, 3);
                auxSets2.add(thirdSet2);
            }
            MatchStadistics statsTwo = new MatchStadistics(auxSets2, auxAccuracy, auxEffect, auxGamesWin, auxUnforcedError, auxWin);

            matchDatabase.setStadistics_1(statsOne);
            matchDatabase.setStadistics_2(statsTwo);
            matchRepository.save(matchDatabase);
        }

        return "/adminPage";
    }

    public Match findMatchByTeams(Team teamOne, Team teamTwo, Tournament tournament) {
        List<Match> matches = tournament.getMatches();
        for (Match m : matches) {
            if (!m.isPlayed() && m.hasTeam(teamOne) && m.hasTeam(teamTwo)) {

                return m;
            }
        }
        return null;
    }
}
