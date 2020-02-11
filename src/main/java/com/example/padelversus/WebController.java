package com.example.padelversus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginerror(){
        return "logIn"; //Ver como manejamos el error en el logIn
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
