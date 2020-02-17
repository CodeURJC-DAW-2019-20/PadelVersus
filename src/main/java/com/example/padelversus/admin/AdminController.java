package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchAdmin;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.SetPadel;
import com.example.padelversus.match.Stadistics.SetPadelRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    TeamRepository  teamRepository;
    @Autowired
    SetPadelRepository setPadelRepository;

    @RequestMapping("/adminPage")
    public String adminPage(Model model){
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<Match> allMatches = matchRepository.findAll();
        List<MatchAdmin> matchAdmins = new ArrayList<>();
       // System.out.println(allMatches.toString());

        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            //tournamentService.teamOrder(tournament);
            //TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            //model.addAttribute("tournament-teams-"+tournament.getName(),tournament.getTeams());
            for (Match match: tournament.getMatches()) {
                List<Team> teamList = match.getTeams();
                if(!match.isPlayed()){
                    MatchAdmin matchAdmin = new MatchAdmin(teamList.get(0),teamList.get(1),match.getDate(),tournament);
                    matchAdmins.add(matchAdmin);
                }
            }
            //tournamentService.teamOrder(tournament);
            TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            for(Team team: tournament.getTeams()){
                List<String> lastMatches = tournamentService.lastThreeMatches(tournament, team);
                tournamentDisplay.addTeam(team, 0, 0, lastMatches);
            }
            allTournamentDisplay.add(tournamentDisplay);

        }

        model.addAttribute("tournament-list", allTournamentDisplay);
        //model.addAttribute("tournament-teams",tournament.getTeams());
        //List<Match> allMatches = matchRepository.findAll();
        model.addAttribute("match-list",matchAdmins);


        return "/adminPage";
    }
    @RequestMapping("/prueba")
    public String prueba(){

        return "/prueba";
    }

    @PostMapping("/saveMatch")
    public String savematch(String torneoSeleccionado,String t1_oficial, String t2_oficial, String date) {
        System.out.println(torneoSeleccionado);
        System.out.println(t1_oficial);
        System.out.println(t2_oficial);
        System.out.println("MATCH DATE:"+date);
        Optional<Tournament> tournament = tournamentRepository.findByName(torneoSeleccionado);
        String[] teamName1 = t1_oficial.split(",");
        String[] teamName2 = t2_oficial.split(",");
        Team team1 = new Team();
        for (String s : teamName1) {
            Optional<Team> teamaux = teamRepository.findByName(s);
            if(teamaux.isPresent()){
                //System.out.println(teamaux.get().getName());
                //System.out.println(tournament.get().hasTeam(teamaux.get()));
                if (tournament.get().hasTeam(teamaux.get())) {
                    team1 = teamaux.get();
                    //System.out.println(teamaux.get().getName());
                }
            }
        }
        Team team2 = new Team();
        for (String s : teamName2) {
            Optional<Team> teamaux = teamRepository.findByName(s);
            if(teamaux.isPresent()){
                //System.out.println(teamaux.get().getName());
                //System.out.println(tournament.get().hasTeam(teamaux.get()));
                if (tournament.get().hasTeam(teamaux.get())) {
                    team2 = teamaux.get();
                    //System.out.println(teamaux.get().getName());
                }
            }
        }
        String[] parts = date.split("-");
        Match match = new Match(false, new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])), team1,team2);
        System.out.println(match.toString());
        matchRepository.save(match);
        //Optional<Tournament> tournament = tournamentRepository.findByName(torneoSeleccionado);
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        tournament.get().setMatches(matches);
        tournamentRepository.save(tournament.get()); //save the new match in tournament table

        //System.out.println(team.toString());
        //Match match1 = new Match(date,t1,t2);
        //List<Match> matches = (List<Match>) match;
       // tournament.setMatches(matches);
      //  tournamentRepository.save(tournament);
        //matchRepository.save(match);
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
    @PostMapping("/saveDataMatch")
    public String saveDatamatch(String matchSelect,String accuracy1, String effectiveness1, String games_wins1, String unforcedErrors1, String set1team1, String set2team1, String set3team1, String win1, String accuracy2, String effectiveness2, String games_wins2, String unforcedErrors2, String set1team2, String set2team2, String set3team2, String win2) {
        String[] match = matchSelect.split(",");
        Optional<Team> team1 = teamRepository.findByName(match[1]);
        Optional<Team> team2 = teamRepository.findByName(match[2]);
        Optional<Tournament> tournament = tournamentRepository.findByName(match[3]);
        if(team1.isPresent()){
            System.out.println(team1.get().getName());
        }else{
            System.out.println("NO PRESENT");
        }
        Match matchDatabase = findMatchByTeams(team1.get(), team2.get(), tournament.get());
        if(matchDatabase != null){
            matchDatabase.setPlayed(true);

            int auxAccuracy = Integer.parseInt(accuracy1);
            int auxEffect = Integer.parseInt(effectiveness1);
            int auxGamesWin = Integer.parseInt(games_wins1);
            int auxUnforcedError = Integer.parseInt(unforcedErrors1);
            int auxSet1 = Integer.parseInt(set1team1);
            int auxSet2 = Integer.parseInt(set2team1);
            int auxSet3 = Integer.parseInt(set3team1);
            boolean auxWin = Boolean.parseBoolean(win1);

            List<SetPadel> auxSets = new ArrayList<>();
            SetPadel firstSet = new SetPadel(auxSet1, 1);
            SetPadel secondSet = new SetPadel(auxSet2, 2);
            auxSets.add(firstSet);
            auxSets.add(secondSet);
            setPadelRepository.save(firstSet);
            setPadelRepository.save(secondSet);
            if (auxSet3 != -1){
                SetPadel thirdSet = new SetPadel(auxSet3, 3);
                auxSets.add(thirdSet);
                setPadelRepository.save(thirdSet);
            }
            MatchStadistics statsOne = new MatchStadistics(auxSets, auxAccuracy, auxEffect, auxGamesWin, auxUnforcedError, auxWin);

            auxAccuracy = Integer.parseInt(accuracy2);
            auxEffect = Integer.parseInt(effectiveness2);
            auxGamesWin = Integer.parseInt(games_wins2);
            auxUnforcedError = Integer.parseInt(unforcedErrors2);
            auxSet1 = Integer.parseInt(set1team2);
            auxSet2 = Integer.parseInt(set2team2);
            auxSet3 = Integer.parseInt(set3team2);
            auxWin = Boolean.parseBoolean(win2);

            auxSets.clear();
            firstSet = new SetPadel(auxSet1, 1);
            secondSet = new SetPadel(auxSet2, 2);
            auxSets.add(firstSet);
            auxSets.add(secondSet);
            setPadelRepository.save(firstSet);
            setPadelRepository.save(secondSet);

            if (auxSet3 != -1){
                SetPadel thirdSet2 = new SetPadel(auxSet3, 3);
                auxSets.add(thirdSet2);
                setPadelRepository.save(thirdSet2);
            }
            MatchStadistics statsTwo = new MatchStadistics(auxSets, auxAccuracy, auxEffect, auxGamesWin, auxUnforcedError, auxWin);

            matchDatabase.setStadistics_1(statsOne);
            matchDatabase.setStadistics_2(statsTwo);

            matchRepository.save(matchDatabase);
        }

        /*System.out.println("MATCH DATE:"+matchSelect);
         String[] parts = matchSelect.split("-");
        Date date = new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]) , Integer.parseInt(parts[2]));
        System.out.println(Integer.parseInt(parts[0]));
        System.out.println(Integer.parseInt(parts[1]));
        System.out.println(Integer.parseInt(parts[2]));
        Optional<Match> match = matchRepository.findByDate(new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])));
        if(match.isPresent()){
            System.out.println(match.get().toString());
        }else{
            System.out.println("NOT PRESENT");
        }

        //match.get().setScore(score);
        //matchRepository.save(match.get().getMatch());

        /*System.out.println(torneoSeleccionado);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println("MATCH DATE:"+date);
        Optional<Team> team = teamRepository.findByName(t1);
        Optional<Team> team2 = teamRepository.findByName(t2);
        String[] parts = date.split("-");

        Match match = new Match(new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]) , Integer.parseInt(parts[2])), team.get().getTeam(),team2.get().getTeam());
        matchRepository.save(match);
        Optional<Tournament> tournament = tournamentRepository.findByName(torneoSeleccionado);
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        tournament.get().setMatches(matches);
        tournamentRepository.save(tournament.get()); //save the new match in tournament table

        System.out.println(team.toString());
        //Match match1 = new Match(date,t1,t2);
        //List<Match> matches = (List<Match>) match;
        // tournament.setMatches(matches);
        //  tournamentRepository.save(tournament);
        //matchRepository.save(match);
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

    public Match findMatchByTeams(Team teamOne, Team teamTwo, Tournament tournament){
        List<Match> matches = tournament.getMatches();
        System.out.println(matches.toString());
        for(Match m: matches) {
            System.out.println("siguente match");
            System.out.println(m.toString());
            if (!m.isPlayed() && m.hasTeam(teamOne) && m.hasTeam(teamTwo)) {
                System.out.println("Lo he encontrado");
                System.out.println(m.toString());
                return m;
            }
        }
        return null;
    }
}
