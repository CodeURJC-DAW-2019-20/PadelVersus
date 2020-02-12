package com.example.padelversus;

import com.example.padelversus.match.Match;
import com.example.padelversus.match.MatchRepository;
import com.example.padelversus.match.Stadistics.MatchStadistics;
import com.example.padelversus.match.Stadistics.MatchStadisticsRepository;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchStadisticsRepository matchStadisticsRepository;

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

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);

        MatchStadistics ms1_1 = new MatchStadistics(23,57,50,50);
        MatchStadistics ms1_2 = new MatchStadistics(13,17,0,0);
        MatchStadistics ms2_1 = new MatchStadistics(99,99,99,99);
        MatchStadistics ms2_2 = new MatchStadistics(78,7,9,3);
        MatchStadistics ms3_1 = new MatchStadistics(23,57,50,50);
        MatchStadistics ms3_2 = new MatchStadistics(23,57,50,50);

        Match match1 = new Match("patata","20/20/2020",ms1_1,ms1_2);
        Match match2 = new Match("patata","21/20/2020",ms2_1,ms2_2);
        Match match3 = new Match("patata","22/20/2020",ms3_1,ms3_2);

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);

    }


}
