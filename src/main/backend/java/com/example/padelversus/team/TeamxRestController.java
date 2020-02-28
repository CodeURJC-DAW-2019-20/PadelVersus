package com.example.padelversus.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeamxRestController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/teamx/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id){
        Optional<Team> teamOptional = teamService.getTeam(id);
        return teamOptional.map(team -> new ResponseEntity<>(team, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
