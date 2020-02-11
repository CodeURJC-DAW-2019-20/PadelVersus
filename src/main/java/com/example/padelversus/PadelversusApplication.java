package com.example.padelversus;

import com.example.padelversus.Team.Team;
import com.example.padelversus.Team.TeamRepository;
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
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Team team1 = new Team("Nombre 1");
        Team team2 = new Team("Nombre 2");

        teamRepository.save(team1);
        teamRepository.save(team2);
    }
}
