package com.example.padelversus;

import com.example.padelversus.Team.Team;
import com.example.padelversus.Team.TeamRepository;
import com.example.padelversus.Team.TeamStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Player player = new Player("Daniel", 50);
        Player player1 = new Player("Pedro", 50);

        TeamStatistics ts1 = new TeamStatistics(4,5);
        TeamStatistics ts2 = new TeamStatistics(10,1);

        Team team1 = new Team("Nombre 1", player, ts1);
        Team team2 = new Team("Nombre 2", player1, ts2);

        teamRepository.save(team1);
        teamRepository.save(team2);

        player.setUsername("PEPE");
        playerRepository.save(player);

    }
}
