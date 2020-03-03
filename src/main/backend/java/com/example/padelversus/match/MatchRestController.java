package com.example.padelversus.match;

import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.match.stadistics.SetPadel;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamService;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentService;
import com.example.padelversus.user.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MatchRestController {
    interface CompleteInfoForAMatch extends Match.Basic, Match.Statistics, MatchStadistics.Basic, Match.Teams, MatchStadistics.SetP, SetPadel.Basic,
            Team.Basic {
    }

    @Autowired
    UserComponent userComponent;

    @Autowired
    MatchService matchService;

    @Autowired
    TeamService teamService;
    @Autowired
    TournamentService tournamentService;

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match = matchService.findMatchById(id);
        if (match.isPresent()) {
            return new ResponseEntity<>(match.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/matches/")
    public ResponseEntity<List<Match>> getMatchesNotPlayed(@RequestParam(required = false) Boolean played,
                                                           @RequestParam(required = false) String date,
                                                           @RequestParam(required = false) Long teamId) {
        //Return matches by played
        if (played != null && date == null && teamId == null) {
            if (played) {
                return getListResponseEntity(matchService.getAllPlayed());
            }
            return getListResponseEntity(matchService.getAllNotPlayed());
        }
        //Return matches by future date
        if (played == null && date != null && teamId == null) {
            String[] parsedate = date.split("-");
            LocalDate localdate = LocalDate.of(Integer.parseInt(parsedate[0]), Integer.parseInt(parsedate[1]), Integer.parseInt(parsedate[2]));
            return getListResponseEntity(matchService.findMatchByDateAndPlayedOrderByDate(localdate));
        }
        //Return past matches played by a teamID
        if (played == null && date == null && teamId != null) {
            return getListResponseEntity(matchService.findLastFourMatchesPlayedByTeamId(teamId));
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{tournament}", method = RequestMethod.POST)
    public ResponseEntity<Match> saveMatch(@PathVariable String tournament, @RequestBody MatchCreate match) {
        if (!userComponent.isAdmin()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Tournament> tournament1 = tournamentService.getTournamentByName(tournament);
        Optional<Team> optionalTeam1 = teamService.getTeamByName(match.t1);
        Optional<Team> optionalTeam2 = teamService.getTeamByName(match.t2);
        if (optionalTeam1.isPresent() && optionalTeam2.isPresent() && tournament1.isPresent()) {
            Team team1 = optionalTeam1.get();
            Team team2 = optionalTeam2.get();

            Match optionalMatch = matchService.findMatchByTeams(team1, team2, tournament1.get());
            if (optionalMatch != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            Match matchOf = new Match(false, match.getDate(), team1, team2);
            matchService.saveApiMatch(matchOf, tournament1.get());
            Match matchOficial = matchService.findMatchByTeams(team1, team2, tournament1.get());
            return new ResponseEntity<>(matchOficial, HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Match> saveStatsMatch(@PathVariable Long id, @RequestBody List<MatchStadistics> matchStadistics) {
        if (!userComponent.isAdmin()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Match> match = matchService.findMatchById(id);
        if (match.isPresent()) {
            Match matchOficial = match.get();
            matchOficial.setStadistics_1(matchStadistics.get(0));
            matchOficial.setStadistics_2(matchStadistics.get(1));
            matchOficial.getTeams().get(0).updateTeamStatistics(matchStadistics.get(0));
            matchOficial.getTeams().get(1).updateTeamStatistics(matchStadistics.get(1));
            matchService.saveMatch(matchOficial);
            return new ResponseEntity<>(matchOficial, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    private ResponseEntity<List<Match>> getListResponseEntity(List<Match> lastFourMatchesPlayedByTeamId) {
        List<Match> matchforteam = lastFourMatchesPlayedByTeamId;
        if (matchforteam.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matchforteam, HttpStatus.OK);
    }

}
