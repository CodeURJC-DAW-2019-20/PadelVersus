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
                                                           @RequestParam (required = false) String idJugador,
                                                           @RequestParam (required = false) String nombreEquipo) {
        //Return matches by played
        if(played!=null && date==null && idJugador==null && nombreEquipo==null){
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
        //Return matches by future date
        if(played==null && date!=null && idJugador==null && nombreEquipo==null){
            String[] parsedate = date.split("-");
            LocalDate localdate = LocalDate.of(Integer.parseInt(parsedate[0]),Integer.parseInt(parsedate[1]),Integer.parseInt(parsedate[2]));
            List<Match> matchnotplayed = matchService.findMatchByDateAndPlayedOrderByDate(localdate);
            if(matchnotplayed.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(matchnotplayed,HttpStatus.OK);
        }
        //Return matches by future date
        if(played==null && date!=null && idJugador==null && nombreEquipo==null){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
