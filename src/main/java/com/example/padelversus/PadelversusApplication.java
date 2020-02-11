package com.example.padelversus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PadelversusApplication /*implements ApplicationRunner*/ {

    @Autowired
    private PlayerRepository2 playerRepository2;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");


    }

    /*

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Player2 player21 = new Player2("Nombre 1", 1);
        Player2 player2 = new Player2("Nombre 2", 2);
        Player2 player23 = new Player2("Nombre 3", 3);
        Player2 player24 = new Player2("Nombre 4", 4);

        playerRepository2.save(player21);
        playerRepository2.save(player2);
        playerRepository2.save(player23);
        playerRepository2.save(player24);
    }
    */

}
