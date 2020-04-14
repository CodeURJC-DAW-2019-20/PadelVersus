package com.example.padelversus.security;

import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public String login() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return username.equals("anonymousUser") ? "login" : "index";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
