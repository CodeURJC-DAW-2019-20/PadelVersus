package com.example.padelversus;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.MatchStadisticsRepository;
import com.example.padelversus.match.Stadistics.SetPadel;
import com.example.padelversus.match.Stadistics.SetPadelRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.team.teamstatistics.TeamStatistics;
import com.example.padelversus.team.teamstatistics.TeamStatisticsRepository;
import com.example.padelversus.team.teamstatistics.game.Game;
import com.example.padelversus.team.teamstatistics.game.GameRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchStadisticsRepository matchStadisticsRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamStatisticsRepository teamStatisticsRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private SetPadelRepository setPadelRepository;
    @Autowired
    private GameRepository gameRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
    }

    public List<List<SetPadel>> createSets(int n){ //Create n lists with lists of 2 sets
        List<List<SetPadel>> allSets = new ArrayList<>();
        for(int j=0; j<n; j++){
            List<SetPadel> sets = new ArrayList<>();

            SetPadel set1 = new SetPadel(5 + (j%2), 1);
            SetPadel set2 = new SetPadel(6 + (j%2), 1);
            SetPadel set3 = new SetPadel(4 + (j%2), 1);


            setPadelRepository.save(set1);
            setPadelRepository.save(set2);
            setPadelRepository.save(set3);

            sets.add(set1);
            sets.add(set2);
            sets.add(set3);

            allSets.add(sets);
        }

        return allSets;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Save teams and player
        Player player1 = new Player( 14,  1.68, 60, 1, 5.6, 8,10 , 10, 2.5,"Spain");
        Player player2 = new Player( 16, 1.70, 65, 2, 4.4,  6.8, 9,2 , 4.6,"France");
        Player player3 = new Player( 23, 1.72, 66, 3, 5, 5, 2, 2, 5.6, "Netherland");
        Player player4 = new Player( 24, 1.78, 67, 4, 3.7, 6.7, 3, 5, 6.7, "Spain");
        Player player5 = new Player( 25, 1.79, 89, 5, 3.5, 3, 4, 6, 6.9, "Portugal");
        Player player6 = new Player( 26, 1.87, 70, 6, 3.7, 5, 5, 7, 7.0, "United Kindgdom");
        Player player7 = new Player( 28, 1.9, 73, 7, 3.3, 6, 7, 8, 7.2, "United Kindgdom");
        Player player8 = new Player( 31, 1.8, 75, 8, 3.2, 6.7, 8, 7, 6.4, "France");
        Player player9 = new Player( 32, 1.8, 77, 9, 1.6, 6.8, 9, 6, 5.6, "Spain");
        Player player10 = new Player( 33, 1.5, 70, 7, 1.7, 4.6, 10, 8, 6.7, "Spain");
        Player player11 = new Player( 35, 1.7, 51, 8, 1.8, 4.6, 3, 9, 8.8, "France");
        Player player12 = new Player( 47, 1.5, 58, 6, 1.9, 4.8, 4, 2, 9.9, "France");
        Player player13 = new Player( 45, 1.6, 60, 7, 1.5, 4.3, 4.6, 3, 3.4, "Netherland");
        Player player14 = new Player( 24, 1.8, 62, 9, 1.4, 3.2, 5.7, 4, 5.6, "Netherland");
        Player player15 = new Player( 48, 1.9, 45, 10, 1.3, 3.4, 5.6, 5, 6.7, "France");
        Player player16 = new Player( 50, 1.4, 67, 10, 1.2, 5.7, 5.6, 6, 7.6, "France");
        Player player17 = new Player( 29, 1.6, 69, 9, 1.1, 5.8, 6.7, 7, 6.7, "Spain");
        Player player18 = new Player( 21, 1.7, 70, 8, 5.6, 5.9, 3.4, 8, 4.5, "Spain");
        Player player19 = new Player( 39, 1.8, 76, 7, 5.8, 3.4, 5.6, 9, 6.7, "United Kindgdom");
        Player player20 = new Player( 40, 1.9, 40, 6, 5.9, 5.4, 5.8, 10, 5.6, "United Kindgdom");

        Team t1 = new Team("Danielos - T1", player1, player2);
        Team t2 = new Team("Joselos - T2", player3, player4);
        Team t3 = new Team("Papateros - T3", player5, player6);
        Team t4 = new Team("Leones - T4", player7, player8);
        Team t5 = new Team("Tigres - T5", player9, player10);
        Team t6 = new Team("Donuts - T6", player11, player12);
        Team t7 = new Team("PapdelTeam - T7", player13, player14);
        Team t8 = new Team("VersusTeam - T8", player15, player16);
        Team t9 = new Team("Luqueros - T9", player17, player18);
        Team t10 = new Team("Jamoneros - T10", player18, player20);

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);
        playerRepository.save(player6);
        playerRepository.save(player7);
        playerRepository.save(player8);
        playerRepository.save(player9);
        playerRepository.save(player10);
        playerRepository.save(player11);
        playerRepository.save(player12);
        playerRepository.save(player13);
        playerRepository.save(player14);
        playerRepository.save(player15);
        playerRepository.save(player16);
        playerRepository.save(player17);
        playerRepository.save(player18);
        playerRepository.save(player19);
        playerRepository.save(player19);
        playerRepository.save(player20);

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);
        teamRepository.save(t4);
        teamRepository.save(t5);
        teamRepository.save(t6);
        teamRepository.save(t7);
        teamRepository.save(t8);
        teamRepository.save(t9);
        teamRepository.save(t10);

        //Example test
        List<List<SetPadel>> thirtySixSets = createSets(36);
        // Save tournaments and mathches
        // Tournament 1
        MatchStadistics ms1_1 = new MatchStadistics(thirtySixSets.get(0),23, 57, 50, 50, true);
        MatchStadistics ms1_2 = new MatchStadistics(thirtySixSets.get(1),13, 17, 0, 0, false);
        Match match1 = new Match(true,"t1 vs t2 win t1", new Date(2020, Calendar.OCTOBER, 20), ms1_1, ms1_2, t1, t2);
        t1.addMatch(match1);

        MatchStadistics ms2_1 = new MatchStadistics(thirtySixSets.get(2),23, 57, 50, 50, true);
        MatchStadistics ms2_2 = new MatchStadistics(thirtySixSets.get(3), 13, 17, 0, 0, false);
        Match match2 = new Match(true,"t1 vs t3 win t1", new Date(2020, Calendar.OCTOBER, 21), ms2_1, ms2_2, t1, t3);
        t1.addMatch(match2);

        MatchStadistics ms3_1 = new MatchStadistics(thirtySixSets.get(4),23, 57, 50, 50, true);
        MatchStadistics ms3_2 = new MatchStadistics(thirtySixSets.get(5),13, 17, +0, 0, false);
        Match match3 = new Match(true,"t1 vs t4 win t4", new Date(2020, Calendar.OCTOBER, 22), ms3_1, ms3_2, t4, t1);
        t1.addMatch(match3);

        MatchStadistics ms4_1 = new MatchStadistics(thirtySixSets.get(6),99, 99, 99, 99, true);
        MatchStadistics ms4_2 = new MatchStadistics(thirtySixSets.get(7),78, 7, 9, 3, false);
        Match match4 = new Match(true,"t2 vs t3 win t2", new Date(2020, Calendar.OCTOBER, 23), ms4_1, ms4_2, t2, t3);

        MatchStadistics ms5_1 = new MatchStadistics(thirtySixSets.get(8),23, 57, 50, 50, false);
        MatchStadistics ms5_2 = new MatchStadistics(thirtySixSets.get(9),23, 57, 50, 50, true);
        Match match5 = new Match(true,"t2 vs t4 win t4", new Date(2020, Calendar.OCTOBER, 24), ms5_1, ms5_2, t2, t4);

        MatchStadistics ms6_1 = new MatchStadistics(thirtySixSets.get(10),23, 57, 50, 50, true);
        MatchStadistics ms6_2 = new MatchStadistics(thirtySixSets.get(11),23, 57, 50, 50, false);
        Match match6 = new Match(true,"t3 vs t3 win t4", new Date(2020, Calendar.OCTOBER, 25), ms6_1, ms6_2, t4, t3);

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);
        matchRepository.save(match4);
        matchRepository.save(match5);
        matchRepository.save(match6);

        ArrayList<Match> tournament1_matches = new ArrayList<>();
        tournament1_matches.add(match1);
        tournament1_matches.add(match2);
        tournament1_matches.add(match3);
        tournament1_matches.add(match4);
        tournament1_matches.add(match5);
        tournament1_matches.add(match6);

        ArrayList<Team> teamsTournament1 = new ArrayList<>();
        teamsTournament1.add(t1);
        teamsTournament1.add(t2);
        teamsTournament1.add(t3);
        teamsTournament1.add(t4);

        Tournament tournament1 = new Tournament("Tournament 1", tournament1_matches, teamsTournament1);
        tournamentRepository.save(tournament1);

        // Tournament 2
        MatchStadistics ms7_1 = new MatchStadistics(thirtySixSets.get(12),23, 57, 50, 50, false);
        MatchStadistics ms7_2 = new MatchStadistics(thirtySixSets.get(13),23, 57, 50, 50, true);
        Match match7 = new Match(true,"t4 vs t5 win t5", new Date(2020, Calendar.NOVEMBER, 20), ms7_1, ms7_2, t4, t5);

        MatchStadistics ms8_1 = new MatchStadistics(thirtySixSets.get(14),23, 57, 50, 50, false);
        MatchStadistics ms8_2 = new MatchStadistics(thirtySixSets.get(15),23, 57, 50, 50, true);
        Match match8 = new Match(true,"t4 vs t6 wins t6", new Date(2020, Calendar.NOVEMBER, 21), ms8_1, ms8_2, t4, t6);

        MatchStadistics ms9_1 = new MatchStadistics(thirtySixSets.get(16),23, 57, 50, 50, false);
        MatchStadistics ms9_2 = new MatchStadistics(thirtySixSets.get(17),23, 57, 50, 50, true);
        Match match9 = new Match(true,"t4 vs t7 wins t7", new Date(2020, Calendar.NOVEMBER, 22), ms9_1, ms9_2, t4, t7);

        MatchStadistics ms10_1 = new MatchStadistics(thirtySixSets.get(18),23, 57, 50, 50, false);
        MatchStadistics ms10_2 = new MatchStadistics(thirtySixSets.get(19),23, 57, 50, 50, true);
        Match match10 = new Match(true,"t5 vs t6 wins t6", new Date(2020, Calendar.NOVEMBER, 23), ms10_1, ms10_2, t5, t6);

        MatchStadistics ms11_1 = new MatchStadistics(thirtySixSets.get(20),23, 57, 50, 50, false);
        MatchStadistics ms11_2 = new MatchStadistics(thirtySixSets.get(21),23, 57, 50, 50, true);
        Match match11 = new Match(true,"t5 vs t7 wins t7", new Date(2020, Calendar.NOVEMBER, 24), ms11_1, ms11_2, t5, t7);

        MatchStadistics ms12_1 = new MatchStadistics(thirtySixSets.get(34),23, 57, 50, 50, false);
        MatchStadistics ms12_2 = new MatchStadistics(thirtySixSets.get(35),23, 57, 50, 50, true);
        Match match12 = new Match(true,"t6 vs t7 wins t6", new Date(2020, Calendar.NOVEMBER, 25), ms12_1, ms12_2, t7, t6);

        matchRepository.save(match7);
        matchRepository.save(match8);
        matchRepository.save(match9);
        matchRepository.save(match10);
        matchRepository.save(match11);
        matchRepository.save(match12);

        List<Match> tournament2_matches = new ArrayList<>();
        tournament2_matches.add(match7);
        tournament2_matches.add(match8);
        tournament2_matches.add(match9);
        tournament2_matches.add(match10);
        tournament2_matches.add(match11);
        tournament2_matches.add(match12);

        List<Team> teamsTournament2 = new ArrayList<>();
        teamsTournament2.add(t4);
        teamsTournament2.add(t5);
        teamsTournament2.add(t6);
        teamsTournament2.add(t7);
        Tournament tournament2 = new Tournament("Tournament 2", tournament2_matches, teamsTournament2);
        tournamentRepository.save(tournament2);

        // Tournament 3
        MatchStadistics ms13_1 = new MatchStadistics(thirtySixSets.get(22),23, 57, 50, 50, false);
        MatchStadistics ms13_2 = new MatchStadistics(thirtySixSets.get(23),23, 57, 50, 50, true);
        Match match13 = new Match(true,"t6 vs t8 win t6", new Date(2020, Calendar.DECEMBER, 20), ms13_1, ms13_2, t8, t6);

        MatchStadistics ms14_1 = new MatchStadistics(thirtySixSets.get(24),23, 57, 50, 50, false);
        MatchStadistics ms14_2 = new MatchStadistics(thirtySixSets.get(25),23, 57, 50, 50, true);
        Match match14 = new Match(true,"t6 vs t9 wins t9", new Date(2020, Calendar.DECEMBER, 21), ms14_1, ms14_2, t6, t9);

        MatchStadistics ms15_1 = new MatchStadistics(thirtySixSets.get(26),23, 57, 50, 50, false);
        MatchStadistics ms15_2 = new MatchStadistics(thirtySixSets.get(27),23, 57, 50, 50, true);
        Match match15 = new Match(true,"t6 vs t10 wins t10", new Date(2020, Calendar.DECEMBER, 22), ms15_1, ms15_2, t6, t10);

        MatchStadistics ms16_1 = new MatchStadistics(thirtySixSets.get(28),23, 57, 50, 50, false);
        MatchStadistics ms16_2 = new MatchStadistics(thirtySixSets.get(29),23, 57, 50, 50, true);
        Match match16 = new Match(true,"t8 vs t9 wins t9", new Date(2020, Calendar.DECEMBER, 23), ms16_1, ms16_2, t8, t9);

        MatchStadistics ms17_1 = new MatchStadistics(thirtySixSets.get(30),23, 57, 50, 50, false);
        MatchStadistics ms17_2 = new MatchStadistics(thirtySixSets.get(31),23, 57, 50, 50, true);
        Match match17 = new Match(true,"t8 vs t10 wins t10", new Date(2020, Calendar.DECEMBER, 24), ms17_1, ms17_2, t8, t10);

        MatchStadistics ms18_1 = new MatchStadistics(thirtySixSets.get(32),23, 57, 50, 50, false);
        MatchStadistics ms18_2 = new MatchStadistics(thirtySixSets.get(33),23, 57, 50, 50, true);
        Match match18 = new Match(true,"t9 vs t10 wins t10", new Date(2020, Calendar.DECEMBER, 25), ms18_1, ms18_2, t9, t10);

        matchRepository.save(match13);
        matchRepository.save(match14);
        matchRepository.save(match15);
        matchRepository.save(match16);
        matchRepository.save(match17);
        matchRepository.save(match18);

        List<Match> tournament3_matches = new ArrayList<>();
        tournament3_matches.add(match13);
        tournament3_matches.add(match14);
        tournament3_matches.add(match15);
        tournament3_matches.add(match16);
        tournament3_matches.add(match17);
        tournament3_matches.add(match18);

        List<Team> teamsTournament3 = new ArrayList<>();
        teamsTournament3.add(t6);
        teamsTournament3.add(t8);
        teamsTournament3.add(t9);
        teamsTournament3.add(t10);

        Tournament tournament3 = new Tournament("Tournament 3", tournament3_matches, teamsTournament3);
        tournamentRepository.save(tournament3);

        teamRepository.save(t1);

    }


}
