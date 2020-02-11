package com.example.padelversus;

import com.example.padelversus.Team.Team;
import com.example.padelversus.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        Team team1 = new Team("Nombre 1", player);
        Team team2 = new Team("Nombre 2", player1);

        teamRepository.save(team1);
        teamRepository.save(team2);

        player.setUsername("PEPE");
        playerRepository.save(player);

        Long a = Integer.toUnsignedLong(1);
        Optional<Team> team = teamRepository.findByid(a);
        Player p = team.get().getPlayerOne();
        System.out.println(p.getUsername());

    }
}
