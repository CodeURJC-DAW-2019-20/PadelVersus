package com.example.padelversus.tournament;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchAdmin;
import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamService;
import com.example.padelversus.tournament.display.TournamentDisplay;
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
            Team.Basic {}

    @Autowired
    TournamentService tournamentService;

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @JsonView(BasicMatchMatchStatisticsTeams.class)
    @GetMapping("/tournament/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Optional<Tournament> tournamentOptional = tournamentService.getTournamentById(id);
        return tournamentOptional.map(tournament -> new ResponseEntity<>(tournament, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @JsonView(BasicMatchMatchStatisticsTeams.class)
    @GetMapping("/tournaments/")
    public ResponseEntity<List<Tournament>> getTournamentByName(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) Long playerId,
                                                                @RequestParam(required = false) Long teamId
    ) {
        if (name != null && playerId == null  && teamId == null) { //Only name
            Optional<Tournament> tournamentOptional = tournamentService.getTournamentByName(name);
            if (tournamentOptional.isPresent()) {
                ArrayList<Tournament> tournamentName = new ArrayList<>();
                tournamentName.add(tournamentOptional.get());
                return new ResponseEntity<>(tournamentName, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        if (name == null && playerId != null && teamId == null) { //Only playerId
            Optional<Player> playerOptional = playerService.findPlayerById(playerId);
            if (!playerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournaments = playerService.findTournamentsOfPlayer(playerOptional.get());
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        if(name != null && playerId != null && teamId == null){ //Name and playerId
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
        if(name == null && playerId == null && teamId != null){ //Only teamId
            Optional<Team> teamOptional = teamService.getTeam(teamId);
            if(!teamOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournaments = tournamentService.findTournamentByTeamId(teamId);
            if(tournaments == null ||tournaments.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        if(name != null && playerId == null && teamId != null){ //Name and teamID
            Optional<Team> teamOptional = teamService.getTeam(teamId);
            if(!teamOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournaments = tournamentService.findTournamentByTeamId(teamId);
            if(tournaments == null ||tournaments.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Tournament tournament = null;
            for (Tournament tournamentOnCheck : tournaments) {
                if(tournamentOnCheck.getName().equals(name)){
                    tournament = tournamentOnCheck;
                }
            }
            if(tournament == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Tournament> tournamentsName = new ArrayList<>();
            tournamentsName.add(tournament);
            return new ResponseEntity<>(tournamentsName, HttpStatus.OK);
        }
        if(name == null && playerId == null && teamId == null) {
            List<Tournament> tournaments = tournamentService.getAllTournament();
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

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

    @JsonView(BasicMatchMatchStatisticsTeams.class)
    @PostMapping("/tournament/")
    public ResponseEntity<Tournament> saveTournament(@RequestBody Tournament tournament ) {
        String name = tournament.getName();
        Optional<Tournament> optionalTournament = tournamentService.getTournamentByName(name);

        if(optionalTournament.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Tournament newTournament = new Tournament(name);
        tournamentService.saveTournament(newTournament);
        Tournament tour = tournamentService.getTournamentByName(name).get();
        return new ResponseEntity<>(tour,HttpStatus.CREATED);

    }
}
