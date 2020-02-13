package com.example.padelversus;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.MatchStadisticsRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.team.TeamStatistics;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
    private TournamentRepository tournamentRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Save teams and player
        Player player1 = new Player("Lucas","lucasgt",14,1.68,60,"tortuga","RayoTeam",5.6,8,"Spain");
        Player player2 = new Player("Alex","alexcf",16,1.86,66,"leon","CaptainTeam",6.8,10,"France");
        Player player3 = new Player("Jose","joseluisls",29,1.89,50,"arena","CaptianTeam",5,10,"Netherland");
        Player player4 = new Player("Dani","danicp",20,1.40,59,"sombrilla","RayoTeam",4,7,"Sweden");
        Player player5 = new Player("Ivan","ivanms",10,1.59,67,"alfombra","RelampagoTeam",6,9,"United Kingdom");
        Player player6 = new Player("Juan","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player7 = new Player("Pedro","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player8 = new Player("Luis","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player9 = new Player("Mario","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player10 = new Player("Guillermo","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player11 = new Player("Luis","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player12 = new Player("Israel","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player13 = new Player("Maria","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player14 = new Player("Pilar","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player15 = new Player("Alejandra","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player16 = new Player("Carmen","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player17 = new Player("Nerea","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player18 = new Player("Daniel","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player19 = new Player("Manuel","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");
        Player player20 = new Player("Ana","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");

        Team t1 =new Team("Danielos",player1,player2,new TeamStatistics(10,40));
        Team t2 =new Team("Joselos",player3,player4,new TeamStatistics(15,45));
        Team t3 =new Team("Papateros",player5,player6,new TeamStatistics(20,42));
        Team t4 =new Team("Leones",player7,player8,new TeamStatistics(20,42));
        Team t5 =new Team("Tigres",player9,player10,new TeamStatistics(20,42));
        Team t6 =new Team("Donuts",player11,player12,new TeamStatistics(20,42));
        Team t7 =new Team("PapdelTeam",player13,player14,new TeamStatistics(20,42));
        Team t8 =new Team("VersusTeam",player15,player16,new TeamStatistics(20,42));
        Team t9 =new Team("Luqueros",player17,player18,new TeamStatistics(20,42));
        Team t10 =new Team("Jamoneros",player18,player20,new TeamStatistics(20,42));

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

        // Save tournaments and mathches
        // Tournament 1

        MatchStadistics ms1_1 = new MatchStadistics(23,57,50,50,true);
        MatchStadistics ms1_2 = new MatchStadistics(13,17,0,0, false);
        Match match1 = new Match("t1 vs t2 win t1","20/20/2020",ms1_1,ms1_2,t1,t2);

        MatchStadistics ms2_1 = new MatchStadistics(23,57,50,50,true);
        MatchStadistics ms2_2 = new MatchStadistics(13,17,0,0, false);
        Match match2 = new Match("t1 vs t3 win t1","20/20/2020",ms2_1,ms2_2,t1,t3);

        MatchStadistics ms3_1 = new MatchStadistics(23,57,50,50,true);
        MatchStadistics ms3_2 = new MatchStadistics(13,17,+0,0, false);
        Match match3 = new Match("t1 vs t4 win t4","20/20/2020",ms3_1,ms3_2,t4,t1);

        MatchStadistics ms4_1 = new MatchStadistics(99,99,99,99,true);
        MatchStadistics ms4_2 = new MatchStadistics(78,7,9,3,false);
        Match match4 = new Match("t2 vs t3 win t2","21/20/2020",ms4_1,ms4_2,t2,t3);

        MatchStadistics ms5_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms5_2 = new MatchStadistics(23,57,50,50,true);
        Match match5 = new Match("t2 vs t4 win t4","22/20/2020",ms5_1,ms5_2,t2,t4);

        MatchStadistics ms6_1 = new MatchStadistics(23,57,50,50,true);
        MatchStadistics ms6_2 = new MatchStadistics(23,57,50,50,false);
        Match match6 = new Match("t3 vs t3 win t4","22/20/2020",ms6_1,ms6_2,t4,t3);

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);
        matchRepository.save(match4);
        matchRepository.save(match5);
        matchRepository.save(match6);

        List<Match> tournament1_matches =  new ArrayList<>();
        tournament1_matches.add(match1);
        tournament1_matches.add(match2);
        tournament1_matches.add(match3);
        tournament1_matches.add(match4);
        tournament1_matches.add(match5);
        tournament1_matches.add(match6);

        List<Team> teamsTournament1 = new ArrayList<>();
        teamsTournament1.add(t1);
        teamsTournament1.add(t2);
        teamsTournament1.add(t3);
        teamsTournament1.add(t4);

        Tournament tournament1 = new Tournament("Tournament 1", tournament1_matches, teamsTournament1);
        tournamentRepository.save(tournament1);

        // Tournament 2
        MatchStadistics ms7_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms7_2 = new MatchStadistics(23,57,50,50,true);
        Match match7 = new Match("t4 vs t5 win t5","22/20/2020",ms7_1,ms7_2,t4,t5);

        MatchStadistics ms8_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms8_2 = new MatchStadistics(23,57,50,50,true);
        Match match8 = new Match("t4 vs t6 wins t6","22/20/2020",ms8_1,ms8_2,t4,t6);

        MatchStadistics ms9_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms9_2 = new MatchStadistics(23,57,50,50,true);
        Match match9 = new Match("t4 vs t7 wins t7","22/20/2020",ms9_1,ms9_2,t4,t7);

        MatchStadistics ms10_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms10_2 = new MatchStadistics(23,57,50,50,true);
        Match match10 = new Match("t5 vs t6 wins t6","22/20/2020",ms10_1,ms10_2,t5,t6);

        MatchStadistics ms11_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms11_2 = new MatchStadistics(23,57,50,50,true);
        Match match11 = new Match("t5 vs t7 wins t7","22/20/2020",ms11_1,ms11_2,t5,t7);

        MatchStadistics ms12_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms12_2 = new MatchStadistics(23,57,50,50,true);
        Match match12 = new Match("t6 vs t7 wins t6","22/20/2020",ms12_1,ms12_2,t7,t6);

        matchRepository.save(match7);
        matchRepository.save(match8);
        matchRepository.save(match9);
        matchRepository.save(match10);
        matchRepository.save(match11);
        matchRepository.save(match12);

        List<Match> tournament2_matches =  new ArrayList<>();
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
        MatchStadistics ms13_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms13_2 = new MatchStadistics(23,57,50,50,true);
        Match match13 = new Match("t6 vs t8 win t6","22/20/2020",ms13_1,ms13_2,t8,t6);

        MatchStadistics ms14_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms14_2 = new MatchStadistics(23,57,50,50,true);
        Match match14 = new Match("t6 vs t9 wins t9","22/20/2020",ms14_1,ms14_2,t6,t9);

        MatchStadistics ms15_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms15_2 = new MatchStadistics(23,57,50,50,true);
        Match match15 = new Match("t6 vs t10 wins t10","22/20/2020",ms15_1,ms15_2,t6,t10);

        MatchStadistics ms16_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms16_2 = new MatchStadistics(23,57,50,50,true);
        Match match16 = new Match("t8 vs t9 wins t9","22/20/2020",ms16_1,ms16_2,t8,t9);

        MatchStadistics ms17_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms17_2 = new MatchStadistics(23,57,50,50,true);
        Match match17 = new Match("t8 vs t10 wins t10","22/20/2020",ms17_1,ms17_2,t8,t10);

        MatchStadistics ms18_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms18_2 = new MatchStadistics(23,57,50,50,true);
        Match match18 = new Match("t9 vs t10 wins t10","22/20/2020",ms18_1,ms18_2,t9,t10);

        matchRepository.save(match13);
        matchRepository.save(match14);
        matchRepository.save(match15);
        matchRepository.save(match16);
        matchRepository.save(match17);
        matchRepository.save(match18);

        List<Match> tournament3_matches =  new ArrayList<>();
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


    }


}
