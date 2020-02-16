package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
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
    @RequestMapping("/adminPage")
    public String adminPage(Model model){
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<Match> allMatches = matchRepository.findAll();
        List<Match> matchesNull = allMatches;
       // System.out.println(allMatches.toString());
       for (int i = 0; i < allMatches.size(); i++) {
            if(allMatches.get(i).getScore()!= null){
                //allMatches.remove(i);
            }
        }
        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            //tournamentService.teamOrder(tournament);
            //TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            model.addAttribute("tournament-teams-"+tournament.getName(),tournament.getTeams());

            // allTournamentDisplay.add(tournamentDisplay);
        }
        model.addAttribute("tournament-list", allTournament);
        //model.addAttribute("tournament-teams",tournament.getTeams());
        //List<Match> allMatches = matchRepository.findAll();
        model.addAttribute("match-list",allMatches);
        return "/adminPage";
    }
    @RequestMapping("/prueba")
    public String prueba(){

        return "/prueba";
    }

    @PostMapping("/saveMatch")
    public String savematch(String torneoSeleccionado,String t1, String t2, String date) {
        System.out.println(torneoSeleccionado);
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
    @PostMapping("/saveDataMatch")
    public String saveDatamatch(String matchSelect,String score) {
        System.out.println("MATCH DATE:"+matchSelect);
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
}
