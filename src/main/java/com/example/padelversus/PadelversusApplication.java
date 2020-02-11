package com.example.padelversus;

import com.example.padelversus.Player.Player;
import com.example.padelversus.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    @Autowired
    PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");


    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        Player player1 = new Player("Lucas","lucasgt",14,1.68,60,"tortuga","RayoTeam",5.6,8);
        Player player2 = new Player("Alex","alexcf",16,1.86,66,"leon","CaptainTeam",6.8,10);
        Player player3 = new Player("Jose","joseluisls",29,1.89,50,"arena","CaptianTeam",5,10);
        Player player4 = new Player("Dani","danicp",20,1.40,59,"sombrilla","RayoTeam",4,7);
        Player player5 = new Player("Ivan","ivanms",10,1.59,67,"alfombra","RelampagoTeam",6,9);

        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);


    }


}
