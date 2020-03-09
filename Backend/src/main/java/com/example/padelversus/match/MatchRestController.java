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

    @JsonView(CompleteInfoForAMatch.class)
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match = matchService.findMatchById(id);
        if (match.isPresent()) {
            return new ResponseEntity<>(match.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @JsonView(CompleteInfoForAMatch.class)
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
        if (played == null && date == null && teamId == null) {
            return getListResponseEntity(matchService.findAll());
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    public static class MatchCreate {
        private String t1;
        private String t2;
        private LocalDate date;

        public MatchCreate(String t1, String t2, LocalDate date) {
            this.t1 = t1;
            this.t2 = t2;
            this.date = date;
        }

        public String getT1() {
            return t1;
        }

        public void setT1(String t1) {
            this.t1 = t1;
        }

        public String getT2() {
            return t2;
        }

        public void setT2(String t2) {
            this.t2 = t2;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }
    }

    @JsonView(CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{tournamentName}", method = RequestMethod.POST)
    public ResponseEntity<Match> saveMatch(@PathVariable String tournamentName, @RequestBody MatchCreate match) {


        // Parse params on Request Body
        String t1_name = match.getT1();
        String t2_name = match.getT2();
        LocalDate date = match.getDate();


        Optional<Tournament> tournamentOptional = tournamentService.getTournamentByName(tournamentName);

        Optional<Team> optionalTeam1 = teamService.getTeamByName(t1_name);

        Optional<Team> optionalTeam2 = teamService.getTeamByName(t2_name);

        if (optionalTeam1.isPresent() && optionalTeam2.isPresent() && tournamentOptional.isPresent()) {

            Team team1 = optionalTeam1.get();
            Team team2 = optionalTeam2.get();

            Tournament tournament = tournamentOptional.get();

            Match optionalMatch = matchService.findMatchByTeams(team1, team2, tournament);

            if (optionalMatch != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

            optionalMatch = matchService.findMatchByTeams(team2, team1, tournament);

            if (optionalMatch != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

            Match matchOf = new Match(false, date, team1, team2);
            matchService.saveApiMatch(matchOf, tournamentOptional.get());

            Match matchOficial = matchService.findMatchByTeams(team1, team2, tournament);
            return new ResponseEntity<>(matchOficial, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @JsonView(CompleteInfoForAMatch.class)
    @RequestMapping(value = "/match/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Match> saveStatsMatch(@PathVariable Long id, @RequestBody List<MatchStadistics> matchStadistics) {

        Optional<Match> match = matchService.findMatchById(id);
        if (match.isPresent()) {
            Match matchOficial = match.get();
            matchOficial.setPlayed(true);
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
