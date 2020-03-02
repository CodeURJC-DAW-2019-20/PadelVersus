package com.example.padelversus.user;

import com.example.padelversus.player.Player;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserRestController{

    @Autowired
    private UserComponent userComponent;

    @Autowired
    private UserService userService;

    interface UserPlayer extends User.Roles, User.Name, User.Email, User.PlayerView, Player.Basic {
    }

    @GetMapping(value="/login")
    @JsonView(UserPlayer.class)
    public ResponseEntity<User> logIn() {
        if (userComponent.getLoggedUser() != null){
            return new ResponseEntity<>(userComponent.getLoggedUser(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping(value = "/saveUser" )
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