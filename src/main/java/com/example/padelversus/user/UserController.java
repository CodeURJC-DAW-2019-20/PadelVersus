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
    public String saveUser(Model model,
                           @RequestParam String name,
                           @RequestParam String mail,
                           @RequestParam String passwordHash
                           ) {
        String userName = userService.saveUser(name, passwordHash, mail);
        if (userName != null) {
            model.addAttribute("user_name", userName);
            model.addAttribute("error_message", false);
            return "signupPlayer";
        } else {
            model.addAttribute("already_register", true);
            return "signup";
        }
    }

    @PostMapping("/signupPlayer")
    public String signupPlayer(Model model, Player player,
                               @RequestParam String username,
                               @RequestParam MultipartFile imagenFile) throws IOException {
        if(imagenFile.getBytes().length == 0){
            model.addAttribute("user_name", username);
            model.addAttribute("error_message", true);
            return "signupPlayer";
        }
        if (playerService.savePlayer(player, username, imagenFile)) {
            return "signupSuccess";
        }
        return "404";
    }


}