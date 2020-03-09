package com.example.padelversus.team;


import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRestController;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeamsRestController {

    interface BasicTeam extends TeamxRestController.TeamPlayersAndStatistics{
    }

    @Autowired
    TeamService teamService;

    @Autowired
    PlayerService playerService;

    @GetMapping("/teamsList/")
    public List<String[]> returnAllTeams(Pageable page) {
        Page<Team> pages = teamService.getPages(page);
        List<String[]> pageTeamNames = teamService.getPageTeamNames(pages);
        return pageTeamNames;
    }

    @JsonView(BasicTeam.class)
    @GetMapping("/teams/")
    public ResponseEntity<List<Team>> getTeamsByPlayerId(@RequestParam(required = false) Long playerId){
        if (playerId != null) {
            Optional<Player> playerOpt = playerService.findPlayerById(playerId);
            if(playerOpt.isPresent()) {
                List<Team> teams = teamService.getTeamsByPlayerId(playerOpt.get().getId());
                return new ResponseEntity<>(teams, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else {
            List<Team> allTeams = teamService.getAllTeams();
            return new ResponseEntity<>(allTeams, HttpStatus.OK);
        }
    }
}
