package com.example.padelversus;

import com.example.padelversus.Team.Team;
import com.example.padelversus.Team.TeamRepository;
import com.example.padelversus.Team.TeamStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PadelversusApplication implements ApplicationRunner {

    @Autowired
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(PadelversusApplication.class, args);
        System.out.println("ACABO");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
