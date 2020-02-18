package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/player")

public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ImageService imageService;


    @GetMapping("/")
    public String player(){
        return "player";
    }

    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id) throws IOException {
        Optional<Player> player = playerRepository.findById(id);


        if (player.isPresent()) {

            String usernameLogged = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Player playerFound = player.get();
            User user = playerFound.getUser();

            List<Team> teamsFounds = playerService.findMoreTeamOfEachPlayer(playerFound);
            List<Tournament> tournamentsFounds = playerService.findMoreTournamentOfEachPlayer(playerFound);

            BufferedImage playerImage = playerFound.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player", playerFound.getId(), playerImage);
            String image_url = base_url + image_name;
            if (teamsFounds != null) {
                model.addAttribute("namesTeams", teamsFounds);
                model.addAttribute("is_in_team", true);
            } else {
                model.addAttribute("is_in_team", false);
            }
            if (tournamentsFounds != null) {
                model.addAttribute("namesTournaments", tournamentsFounds);
                model.addAttribute("is_in_tournament", true);
            } else {
                model.addAttribute("is_in_tournament", false);
            }
            model.addAttribute("name", user.getName());
            model.addAttribute("email", user.getMail());
            model.addAttribute("country", player.get().getCountryBirth());
            model.addAttribute("age", player.get().getAge());
            model.addAttribute("height", player.get().getHeight());
            model.addAttribute("weight", player.get().getWeight());
            model.addAttribute("strenght", player.get().getStrength());
            model.addAttribute("endurance", player.get().getEndurance());
            model.addAttribute("pace", player.get().getPace());
            model.addAttribute("speed", player.get().getSpeed());
            model.addAttribute("accuaracy", player.get().getAccuaracy());
            model.addAttribute("aceleration", player.get().getAceleration());
            model.addAttribute("image", image_url);

            // team.ifPresent(value -> model.addAttribute("nameTeam", value.getName()));
            // tournament.ifPresent(value -> model.addAttribute("nameTournament", value.getName()));
            if(!usernameLogged.equals(user.getName())) {
                return "player";
            }else{

                return "playerWithInfo";
            }
        }


        else {
            return "404";
        }
    }

    @GetMapping("/editProfile")
    public String editProfile(Model model){
        String usernameLogged = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("name",usernameLogged);
        return "modifyProfilePlayer";
    }

    @PostMapping("/registerProfileForm")
    public String formRegister(Model model,
                        @RequestParam MultipartFile imageFile) throws IOException {

        System.out.println("Estoy aqui");
        System.out.println(imageFile);
        String usernameLogged = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Player player = playerService.getPlayerFromUsername(usernameLogged);

        return "index";
    }

}
