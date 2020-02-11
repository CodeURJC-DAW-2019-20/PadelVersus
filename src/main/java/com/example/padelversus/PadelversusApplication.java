package com.example.padelversus;

import com.example.padelversus.Match.Match;
import com.example.padelversus.Match.MatchRepository;
import com.example.padelversus.Match.Stadistics.MatchStadistics;
import com.example.padelversus.Match.Stadistics.MatchStadisticsRepository;
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
        Player player1 = new Player("Nombre 1", 1);
        Player player2 = new Player("Nombre 2", 2);
        Player player3 = new Player("Nombre 3", 3);
        Player player4 = new Player("Nombre 4", 4);
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

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
    }
}
