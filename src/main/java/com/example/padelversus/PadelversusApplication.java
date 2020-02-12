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
        Player player1 = new Player("Lucas","lucasgt",14,1.68,60,"tortuga","RayoTeam",5.6,8,"Spain");
        Player player2 = new Player("Alex","alexcf",16,1.86,66,"leon","CaptainTeam",6.8,10,"France");
        Player player3 = new Player("Jose","joseluisls",29,1.89,50,"arena","CaptianTeam",5,10,"Netherland");
        Player player4 = new Player("Dani","danicp",20,1.40,59,"sombrilla","RayoTeam",4,7,"Sweden");
        Player player5 = new Player("Ivan","ivanms",10,1.59,67,"alfombra","RelampagoTeam",6,9,"United Kingdom");
        Player player6 = new Player("Ivan2","ivanms",102,1.592,672,"alfombra2","RelampagoTeam2",62,92,"United Kingdom2");

        Team t1 =new Team("Danielos",player1,player4,new TeamStatistics(10,40));
        Team t2 =new Team("Joselos",player2,player3,new TeamStatistics(15,45));
        Team t3 =new Team("Papateros",player5,player5,new TeamStatistics(20,42));

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);
        playerRepository.save(player6);

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);

        MatchStadistics ms1_1 = new MatchStadistics(23,57,50,50,true);
        MatchStadistics ms1_2 = new MatchStadistics(13,17,0,0, false);
        MatchStadistics ms2_1 = new MatchStadistics(99,99,99,99,true);
        MatchStadistics ms2_2 = new MatchStadistics(78,7,9,3,false);
        MatchStadistics ms3_1 = new MatchStadistics(23,57,50,50,false);
        MatchStadistics ms3_2 = new MatchStadistics(23,57,50,50,true);

        Match match1 = new Match("patata","20/20/2020",ms1_1,ms1_2,t1,t2);
        Match match2 = new Match("patata","21/20/2020",ms2_1,ms2_2,t3,t1);
        Match match3 = new Match("patata","22/20/2020",ms3_1,ms3_2,t2,t3);

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);

        List<Match> tournamrnt1_matches =  new ArrayList<>();
        tournamrnt1_matches.add(match1);
        tournamrnt1_matches.add(match2);
        tournamrnt1_matches.add(match3);
        Tournament tournament1 = new Tournament("Tournament 1", tournamrnt1_matches);

        tournamentRepository.save(tournament1);


    }


}
