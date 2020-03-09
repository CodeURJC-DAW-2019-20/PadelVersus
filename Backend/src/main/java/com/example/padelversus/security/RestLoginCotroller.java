package com.example.padelversus.security;

import com.example.padelversus.player.Player;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserComponent;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RestLoginCotroller {
    interface UserPlayer extends User.Identifier, User.Roles, User.Name, User.Email, User.PlayerView, Player.Basic {
    }
    private static final Logger log = LoggerFactory.getLogger(RestLoginCotroller.class);

    @Autowired
    private UserComponent userComponent;

    @RequestMapping("/api/logIn")
    @JsonView(UserPlayer.class)
    public ResponseEntity<User> logIn() {

        if (!userComponent.isLoggedUser()) {
            log.info("Not user logged");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            User loggedUser = userComponent.getLoggedUser();
            log.info("Logged as " + loggedUser.getName());
            return new ResponseEntity<>(loggedUser, HttpStatus.OK);
        }
    }

    @RequestMapping("/api/logOut")
    public ResponseEntity<Boolean> logOut(HttpSession session) {

        if (!userComponent.isLoggedUser()) {
            log.info("No user logged");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            session.invalidate();
            log.info("Logged out");
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }
}
