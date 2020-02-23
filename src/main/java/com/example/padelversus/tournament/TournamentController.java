package com.example.padelversus.tournament;


import com.example.padelversus.ImageService;
import com.example.padelversus.pdf.PdfService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamService;
import com.example.padelversus.tournament.display.TournamentDisplay;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    TeamService teamService;

    @Autowired
    UserService userService;

    @Autowired
    PlayerService playerService;

    @Autowired
    ImageService imageService;

    @Autowired
    PdfService pdfService;

    @GetMapping("/")
    public String loadTournaments(Model model) {
        List<TournamentDisplay> tournamentList = tournamentService.getTournaments();
        model.addAttribute("tournament-list", tournamentList);
        return "tournaments";
    }

    @GetMapping("/register")
    public String registerTournamnent(Model model) throws IOException {
        List<TournamentDisplay> tournaments = tournamentService.getTournaments();
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (username.equals("admin")) {
            return "/adminPage";
        } else {
            Optional<User> user = userService.findUserByName(username);
            Player loggedPlayer = playerService.getPlayerFromUser(user.get());
            BufferedImage playerImage = loggedPlayer.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player", loggedPlayer.getId(), playerImage);
            String image_url = base_url + image_name;

            List<Player> players = playerService.findAllPlayer();
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
            @RequestParam String teamName
    ) {
        Optional<User> user1 = userService.findUserByName(username);
        Optional<User> user2 = userService.findUserByName(otherPlayer);
        Player player1 = playerService.getPlayerFromUser(user1.get());
        Player player2 = playerService.getPlayerFromUser(user2.get());
        Team team = new Team(teamName, player1, player2);
        teamService.saveTeam(team);
        Tournament tournament = tournamentService.getTournamentByName(SelectedTournament).get();
        tournament.getTeams().add(team);
        tournamentService.saveTournament(tournament);
        return "redirect:/";
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() throws IOException, DocumentException {
        List<TournamentDisplay> tournamentList = tournamentService.getTournaments();
        Path pdfPath = pdfService.createPdf(tournamentList);
        String filename = pdfPath.toFile().getName();
        byte[] content = Files.readAllBytes(pdfPath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}

