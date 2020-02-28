package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.team.Team;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRestController;
import com.example.padelversus.user.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
    interface BasicPlayerUser extends Player.Basic, Player.UserPlayer, User.Name, User.Email, Team

            .Name {

    }

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ImageService imageService;

    @JsonView(BasicPlayerUser.class)
    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> playerOptional = playerService.findPlayerById(id);
        if(playerOptional.isPresent()){
            return new ResponseEntity<>(playerOptional.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
