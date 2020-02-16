package com.example.padelversus.user;

import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;


    @PostMapping("/saveUser")
    public String saveUser(User user, Model model) {
        String userName = userService.saveUser(user);
        if (userName != null) {
            model.addAttribute("user_name", userName);
            return "signupPlayer";
        } else {
            model.addAttribute("already_register", true);
            return "signup";
        }
    }

    @PostMapping("/signupPlayer")
    public String signupPlayer(Player player,
                               @RequestParam String username,
                               @RequestParam MultipartFile imagenFile) throws IOException {
        if (playerService.savePlayer(player, username, imagenFile)) {
            return "signupSuccess";
        }
        return "404";
    }


}