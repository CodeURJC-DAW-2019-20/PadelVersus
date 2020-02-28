package com.example.padelversus.team;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.teamstatistics.TeamStatistics;
import com.example.padelversus.team.teamstatistics.game.Game;
import com.example.padelversus.user.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeamxRestController {

    interface TeamPlayersAndStatistics extends
            Team.Basic, Team.Players, Team.TeamStatistic,
            Player.MinInfo, User.Name,
            TeamStatistics.Basic, Game.Basic {
    }//Need to get imageUrl somehow

    @Autowired
    private TeamService teamService;

    @JsonView(TeamPlayersAndStatistics.class)
    @RequestMapping("/teamx/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id){
        Optional<Team> teamOptional = teamService.getTeam(id);
        return teamOptional.map(team -> new ResponseEntity<>(team, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
