package com.example.padelversus.match;

import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.team.Team;
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
    interface CompleteInfoForAMatch extends Match.Basic,Match.Statistics, MatchStadistics.Basic, Match.Teams,
            Team.Basic{}

    @Autowired
    MatchService matchService = new MatchService();

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match = matchService.findMatchById(id);
        if(match.isPresent()){
            return new ResponseEntity<>(match.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(MatchRestController.CompleteInfoForAMatch.class)
    @GetMapping("/matches/")
    public ResponseEntity<List<Match>> getMatchesNotPlayed(@RequestParam(required = false) Boolean played,
                                                           @RequestParam (required = false) String date,
                                                           @RequestParam (required = false) Long teamId) {
        //Return matches by played
        if(played!=null && date==null && teamId==null){
            if(played){
                return getListResponseEntity(matchService.getAllPlayed());
            }
            return getListResponseEntity(matchService.getAllNotPlayed());
        }
        //Return matches by future date
        if(played==null && date!=null && teamId==null){
            String[] parsedate = date.split("-");
            LocalDate localdate = LocalDate.of(Integer.parseInt(parsedate[0]),Integer.parseInt(parsedate[1]),Integer.parseInt(parsedate[2]));
            return getListResponseEntity(matchService.findMatchByDateAndPlayedOrderByDate(localdate));
        }
        //Return past matches played by a teamID
        if(played==null && date==null && teamId!=null){
            return getListResponseEntity(matchService.findLastFourMatchesPlayedByTeamId(teamId));
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    private ResponseEntity<List<Match>> getListResponseEntity(List<Match> lastFourMatchesPlayedByTeamId) {
        List<Match> matchforteam = lastFourMatchesPlayedByTeamId;
        if (matchforteam.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matchforteam, HttpStatus.OK);
    }
}
