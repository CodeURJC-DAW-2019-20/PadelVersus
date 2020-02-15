package com.example.padelversus.user;

import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private PlayerService playerService;


    @PostMapping("/saveUser")
    public String saveUser(User user, Model model) {
        String userName = userService.saveUser(user);
        if (userName != null) {
            model.addAttribute("user_name", userName);
            return "signupPlayer";
        } else {
            return "404";
        }
    }

    @PostMapping("/signupPlayer")
    public String signupPlayer(Player player, @RequestParam String username) {
        if (playerService.savePlayer(player, username)) {
            return "/signupSuccess";
        }
        return "404";
    }


}