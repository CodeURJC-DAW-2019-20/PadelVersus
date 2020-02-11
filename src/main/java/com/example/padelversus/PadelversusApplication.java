package com.example.padelversus;

import com.example.padelversus.Match.Match;
import com.example.padelversus.Match.MatchRepository;
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
        Match match1 = new Match("patata","20/20/2020");
        Match match2 = new Match("patata","21/20/2020");
        Match match3 = new Match("patata","22/20/2020");
        Match match4 = new Match("patata","23/20/2020");

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);
        matchRepository.save(match4);

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
    }
}
