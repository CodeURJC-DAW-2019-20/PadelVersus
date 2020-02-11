package com.example.padelversus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }
    @RequestMapping("/createuser")
    public String createuser(){
        userRepository.save(new User("user2", "pass", "ROLE_USER"));
        return "createuser";
    }
    @RequestMapping("/loginerror")
    public String loginerror(){
        return "loginerror"; //Ver como manejamos el error en el logIn
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
