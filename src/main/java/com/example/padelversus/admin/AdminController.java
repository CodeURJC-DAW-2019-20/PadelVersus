package com.example.padelversus.admin;

import com.example.padelversus.player.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/adminPage")
    public String adminPage(){

        return "/adminPage";
    }
}
