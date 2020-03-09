package com.example.padelversus.user;

import com.example.padelversus.player.Player;
import com.example.padelversus.security.RestLoginCotroller;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserRestController{

    private static final Logger log = LoggerFactory.getLogger(RestLoginCotroller.class);

    @Autowired
    private UserComponent userComponent;

    @Autowired
    private UserService userService;

    interface UserPlayer extends User.Identifier, User.Roles, User.Name, User.Email, User.PlayerView, Player.Basic {
    }

    @PostMapping(value = "" )
    @JsonView(UserPlayer.class)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        Optional<User> optionalUser = userService.findUserByName(user.getName());
        if(optionalUser.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        Optional<User> user1 = userService.findUserByName(user.getName());
        if(user1.isPresent()){
            return new ResponseEntity<>(user1.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}