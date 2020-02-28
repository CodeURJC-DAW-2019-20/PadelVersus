package com.example.padelversus.match;

import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonView;
import jdk.internal.instrumentation.TypeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Post;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleBiFunction;

@RestController
@RequestMapping("/api")
public class MatchRestController {
    interface CompleteInfoForAMatch extends Match.Basic,Match.Statistics, MatchStadistics.Basic, Match.Teams,
            Team.Basic{}

    @Autowired
    MatchService matchService;

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match = matchService.findMatchById(id);
        if(match.isPresent()){
            return new ResponseEntity<>(match.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/matches/")
    public ResponseEntity<List<Match>> getMatchesNotPlayed(@RequestParam(required = false) Boolean played, @RequestParam) {
        if(played!=null){
            if(played){
                List<Match> matchplayed = matchService.getAllPlayed();
                if(matchplayed.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(matchplayed,HttpStatus.OK);
            }
            List<Match> matchnotplayed = matchService.getAllNotPlayed();
            if(matchnotplayed.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(matchnotplayed, HttpStatus.OK);
        }
    }
    */

   /* @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @PostMapping("/match/")
    public ResponseEntity<Match> saveMatch(@RequestBody Tournament tournament, @RequestBody Team team1, @RequestBody Team team2, @RequestBody Match match){
        Match optionalMatch = matchService.findMatchByTeams(team1,team2,tournament);
        if(optionalMatch!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Match matchOf = new Match(false,match.getDate(),team1,team2);
        matchService.saveMatch(matchOf);
        Match matchOficial = matchService.findMatchByTeams(team1,team2,tournament);
        return new ResponseEntity<>(matchOficial,HttpStatus.CREATED);
    }*/

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{tournament}",method = RequestMethod.POST)
    public ResponseEntity<Match> saveMatchMatch(@RequestParam Tournament tournament, @RequestBody Match match){
        Team team1 = match.getTeams().get(0);
        Team team2 = match.getTeams().get(1);
        Match optionalMatch = matchService.findMatchByTeams(team1,team2,tournament);
        if(optionalMatch!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Match matchOf = new Match(false,match.getDate(),team1,team2);
        matchService.saveApiMatch(matchOf,tournament);
        Match matchOficial = matchService.findMatchByTeams(team1,team2,tournament);
        return new ResponseEntity<>(matchOficial,HttpStatus.CREATED);
    }
    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{tournament}",method = RequestMethod.PUT)
    public ResponseEntity<Match> saveStatsMatch(@RequestParam Tournament tournament, @RequestBody Match match){
        Team team1 = match.getTeams().get(0);
        Team team2 = match.getTeams().get(1);
        Match optionalMatch = matchService.findMatchByTeams(team1,team2,tournament);
        if(optionalMatch!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Match matchOf = new Match(false,match.getDate(),team1,team2);
        matchService.saveApiMatch(matchOf,tournament);
        Match matchOficial = matchService.findMatchByTeams(team1,team2,tournament);
        return new ResponseEntity<>(matchOficial,HttpStatus.CREATED);
    }
}
