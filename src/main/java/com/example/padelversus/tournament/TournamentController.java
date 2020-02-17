package com.example.padelversus.tournament;


import com.example.padelversus.ImageService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    TournamentService tournamentService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlayerService playerService;

    @Autowired
    ImageService imageService;

    @GetMapping("/")
    public String loadTournaments(Model model) {
        model.addAttribute("tournament-list", tournamentService.getTournaments());
        return "Tournaments";
    }

    @GetMapping("/register")
    public String registerTournamnent(Model model) throws IOException {
        List<TournamentDisplay> tournaments = tournamentService.getTournaments();
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByName(username);
        Player loggedPlayer = playerService.getPlayerFromUser(user);
        BufferedImage playerImage = loggedPlayer.getBufferedImage();
        String base_url = "/images_temp/Player/";
        String image_name = imageService.saveImage("Player" , loggedPlayer.getId(), playerImage);
        String image_url = base_url + image_name;
        model.addAttribute("tournament-list", tournaments);
        model.addAttribute("actual_player_name", loggedPlayer.getUser().getName());
        model.addAttribute("actual_player_img", image_url);
        return "registerTournament";
    }

}

