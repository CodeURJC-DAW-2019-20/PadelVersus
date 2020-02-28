package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.display.TeamDisplay;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TournamentRestController {
    interface BasicMatchMatchStatisticsTeams
            extends Tournament.Basic, Tournament.Matches, Tournament.Teams,
            Match.Basic, Match.Statistics,
            MatchStadistics.Basic,
            Team.Basic {
    }

    @Autowired
    TournamentService tournamentService;

    @Autowired
    PlayerService playerService;

    @JsonView(BasicMatchMatchStatisticsTeams.class)
    @GetMapping("/tournament/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Optional<Tournament> tournamentOptional = tournamentService.getTournamentById(id);
        return tournamentOptional.map(tournament -> new ResponseEntity<>(tournament, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @JsonView(BasicMatchMatchStatisticsTeams.class)
    @GetMapping("/tournaments/")
    public ResponseEntity<List<Tournament>> getTournamentByName(@RequestParam(required = false) String name, @RequestParam(required = false) Long playerId) {
        if (name != null && playerId == null) {
            Optional<Tournament> tournamentOptional = tournamentService.getTournamentByName(name);
            if (tournamentOptional.isPresent()) {
                ArrayList<Tournament> tournamentName = new ArrayList<>();
                tournamentName.add(tournamentOptional.get());
                return new ResponseEntity<>(tournamentName, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        if (name == null && playerId != null) {
            Optional<Player> playerOptional = playerService.findPlayerById(playerId);
            if (!playerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournaments = playerService.findTournamentsOfPlayer(playerOptional.get());
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        if(name != null){
            Optional<Player> playerOptional = playerService.findPlayerById(playerId);
            if (!playerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournaments = playerService.findTournamentsOfPlayer(playerOptional.get());
            Tournament tournament = null;
            for (Tournament tournamentOnCheck : tournaments) {
                if(tournamentOnCheck.getName().equals(name)){
                    tournament = tournamentOnCheck;
                }
            }
            if(tournament != null){
                List<Tournament> tournamentsPlayerName = new ArrayList<>();
                tournamentsPlayerName.add(tournament);
                return new ResponseEntity<>(tournamentsPlayerName, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        List<Tournament> tournaments = tournamentService.getAllTournament();
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }



    /*@JsonView(BasicMatchMatchStatisticsTeams.class)
    @GetMapping("/tournaments/")
    public ResponseEntity<List<Tournament>> getTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournament();
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }*/

    @GetMapping("/tournament/{id}/ranking")
    public ResponseEntity<List<TeamDisplay>> getTournamentRanking(@PathVariable Long id) {
        Optional<Tournament> tournamentOptional = tournamentService.getTournamentById(id);
        if (tournamentOptional.isPresent()) {
            Tournament tournament = tournamentOptional.get();
            List<TeamDisplay> ranking = tournamentService.getOrderedTeams(tournament);
            return new ResponseEntity<>(ranking, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
