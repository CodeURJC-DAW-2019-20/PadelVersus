package com.example.padelversus.user;

import com.example.padelversus.mail.NotificationService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;


    @PostMapping("/saveUser")
    public String saveUser(User user, Model model){
        String userName = userService.saveUser(user);
        if(userName != null){
            model.addAttribute("user_name", userName);
            return "signupPlayer";
        }else {
            return "404";
        }
    }

    @PostMapping("/signupPlayer")
    public String signupPlayer(Player player, @RequestParam String username){
        if(playerService.savePlayer(player, username)) {
            return "/signupSuccess";
        }
        return "404";
    }


}