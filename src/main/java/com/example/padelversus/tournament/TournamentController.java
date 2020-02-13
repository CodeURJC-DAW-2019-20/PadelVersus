package com.example.padelversus.tournament;


import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.display.TeamDisplay;
import com.example.padelversus.tournament.display.TournamentDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TournamentController {
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    TournamentService tournamentService;

    @GetMapping("/tournaments")
    public String loadTournament(Model model) {
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            tournamentService.teamOrder(tournament);
            TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            for(Team team: tournament.getTeams()){
                int [] wonPlayed = tournamentService.wonGames(tournament, team);
                tournamentDisplay.addTeam(team, wonPlayed[0], wonPlayed[1]);
            }
            allTournamentDisplay.add(tournamentDisplay);
            /*
            System.out.println(tournament.getName());
            for (Team team : tournament.getTeams()) {
                System.out.println("Team name: " + team.getName() +
                        "\tWon: " + tournamentService.wonGames(tournament, team)[0] +
                        "\tPlayed: "+ tournamentService.wonGames(tournament, team)[1]);
            }
            System.out.println();*/
        }
        /*System.out.println("Estoy en /tournament");
        Optional<Tournament> Optionaltournament = tournamentRepository.getById(1L);
        if (Optionaltournament.isPresent()) {
            Tournament tournament = Optionaltournament.get();
            System.out.println("Torneo encontrado");
            List<Team> tournamentTeams = tournament.getTeams();
            for (Team team : tournamentTeams) {
                int games_won = tournamentService.wonGames(tournament, team);
                System.out.println(team);
                System.out.println("Partidos ganados: " + games_won);
                System.out.println("------------------");
            }
        }
        List<String> tournament_names = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            tournament_names.add(tournament.getName());
        }
        System.out.println(tournament_names);*/
        model.addAttribute("tournament-list", allTournamentDisplay);
        return "Tournaments";
    }

}
