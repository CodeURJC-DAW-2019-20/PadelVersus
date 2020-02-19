package com.example.padelversus.tournament;


import com.example.padelversus.ImageService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.display.TournamentDisplay;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
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

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/")
    public String loadTournaments(Model model) {
        List<TournamentDisplay> tournamentList = tournamentService.getTournaments();
        model.addAttribute("tournament-list", tournamentList);
        return "Tournaments";
    }

    @GetMapping("/register")
    public String registerTournamnent(Model model) throws IOException {
        List<TournamentDisplay> tournaments = tournamentService.getTournaments();
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (username.equals("admin")) {
            return "/adminPage";
        } else {
            User user = userRepository.findByName(username);
            Player loggedPlayer = playerService.getPlayerFromUser(user);
            BufferedImage playerImage = loggedPlayer.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player", loggedPlayer.getId(), playerImage);
            String image_url = base_url + image_name;
            List<Player> players = playerRepository.findAll();
            List<String> playerNames = new ArrayList<>();
            for (Player player : players) {
                if (!player.getUser().getName().equals(username)) {
                    playerNames.add(player.getUser().getName());
                }
            }
            model.addAttribute("tournament-list", tournaments);
            model.addAttribute("actual_player_name", loggedPlayer.getUser().getName());
            model.addAttribute("actual_player_img", image_url);
            model.addAttribute("other_player_names", playerNames);
            return "registerTournament";
        }
    }

    @PostMapping("/registerTournamentForm")
    public String formTournament(
            @RequestParam String SelectedTournament,
            @RequestParam String username,
            @RequestParam String otherPlayer,
            @RequestParam String teamName,
            HttpServletRequest request, HttpServletResponse response
    ) {
        User user1 = userRepository.findByName(username);
        User user2 = userRepository.findByName(otherPlayer);
        Player player1 = playerService.getPlayerFromUser(user1);
        Player player2 = playerService.getPlayerFromUser(user2);
        Team team = new Team(teamName, player1, player2);
        teamRepository.save(team);
        Tournament tournament = tournamentRepository.findByName(SelectedTournament).get();
        tournament.getTeams().add(team);
        tournamentRepository.save(tournament);
        return "index";
    }
}

