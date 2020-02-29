package com.example.padelversus.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user")
public class UserRestController{

    @Autowired
    private UserComponent userComponent;

    @Autowired
    private UserService userService;

    @GetMapping(value="/login")
    public ResponseEntity<User> logIn() {
        if (userComponent.getLoggedUser() != null){
            return new ResponseEntity<>(userComponent.getLoggedUser(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

}