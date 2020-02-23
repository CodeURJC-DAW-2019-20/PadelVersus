package com.example.padelversus.admin;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchAdmin;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.stadistics.MatchStadistics;
import com.example.padelversus.match.stadistics.SetPadel;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.tournament.TournamentService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    TournamentService tournamentService;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchRepository matchRepository;

    public List<Object> adminPage(){
        List<Tournament> allTournament = tournamentRepository.findAll();
        List<MatchAdmin> matchAdmins = new ArrayList<>();

        List<TournamentDisplay> allTournamentDisplay = new ArrayList<>();
        for (Tournament tournament : allTournament) {
            String tournament_name = tournament.getName();
            List<Match> matches = matchRepository.findNotPlayedByTournamentName(tournament_name);
            for (Match match : matches) {
                MatchAdmin matchAdmin = new MatchAdmin(match, tournament_name);
                matchAdmins.add(matchAdmin);
            }
            TournamentDisplay tournamentDisplay = new TournamentDisplay(tournament);
            for (Team team : tournament.getTeams()) {
                List<String> lastMatches = tournamentService.lastThreeMatches(tournament, team);
                boolean hasLastMatches = lastMatches != null;
                tournamentDisplay.addTeam(team, 0, 0, lastMatches, hasLastMatches);
            }
            allTournamentDisplay.add(tournamentDisplay);
        }
        List<Object> list = new ArrayList<>();
        list.add(allTournamentDisplay);
        list.add(matchAdmins);
        return list;
    }

    public Team getTeam(String selectedTournament, String t_oficial) {
        Optional<Tournament> tournament = tournamentRepository.findByName(selectedTournament);
        String[] teamName = t_oficial.split(",");
        Team team = new Team();
        for (String s : teamName) {
            Optional<Team> teamaux = teamRepository.findByName(s);
            if (teamaux.isPresent()) {
                if (tournament.get().hasTeam(teamaux.get())) {
                    team = teamaux.get();
                }
            }
        }
        return team;
    }

    public Match findMatchByTeams(Team teamOne, Team teamTwo, Tournament tournament) {
        Optional<Match> match =  matchRepository.findIdByTeamsNameAndTournamentName(teamOne.getName(), teamTwo.getName(), tournament.getName());
        return match.orElse(null);
    }

    public MatchStadistics calculateStats(String accuracy1, String effectiveness1, String games_wins1, String unforcedErrors1, String set1team1, String set2team1, String set3team1, String win1){
        int auxAccuracy = Integer.parseInt(accuracy1);
        int auxEffect = Integer.parseInt(effectiveness1);
        int auxGamesWin = Integer.parseInt(games_wins1);
        int auxUnforcedError = Integer.parseInt(unforcedErrors1);
        int auxSet1 = Integer.parseInt(set1team1);
        int auxSet2 = Integer.parseInt(set2team1);
        int auxSet3 = Integer.parseInt(set3team1);
        boolean auxWin = win1 != null;

        List<SetPadel> auxSets1 = new ArrayList<>();
        SetPadel firstSet = new SetPadel(auxSet1, 1);
        SetPadel secondSet = new SetPadel(auxSet2, 2);
        auxSets1.add(firstSet);
        auxSets1.add(secondSet);
        if (auxSet3 != -1) {
            SetPadel thirdSet = new SetPadel(auxSet3, 3);
            auxSets1.add(thirdSet);
        }
        MatchStadistics stats = new MatchStadistics(auxSets1, auxAccuracy, auxEffect, auxGamesWin, auxUnforcedError, auxWin);
        return stats;
    }
    public void saveMatch(String selectedTournament, String t1_oficial, String t2_oficial, String date){
        Optional<Tournament> tournament = tournamentService.getTournamentByName(selectedTournament);

        Team team1 = getTeam(selectedTournament, t1_oficial);
        Team team2 = getTeam(selectedTournament, t2_oficial);
        String[] parts = date.split("-");

        Match match = new Match(false, LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), team1, team2);

        matchRepository.save(match);
        team1.addMatch(match);
        team2.addMatch(match);
        teamRepository.save(team1);
        teamRepository.save(team2);
        tournament.get().addMatch(match);
        tournamentRepository.save(tournament.get()); //save the new match in tournament table

    }
}
