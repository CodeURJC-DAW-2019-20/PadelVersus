package com.example.padelversus.player;

import com.example.padelversus.ImageService;
import com.example.padelversus.team.Team;
import com.example.padelversus.team.TeamRepository;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentRepository;
import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;
import java.io.IOException;
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
    public String player(Model model){
        return "player";
    }



    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id) throws IOException {
        Optional<Player> player = playerRepository.findById(id);

        //Optional<Team> team = teamRepository.findByid(id);
        //Optional<Tournament> tournament = tournamentRepository.getById(id);

        if (player.isPresent()) {
            Player playerFound = player.get();
            User user = playerFound.getUser();

            Team team = playerService.findTeamOfPlayer(playerFound);
            Tournament tournament = playerService.findTournamentOfPlayer(playerFound);
            BufferedImage playerImage = playerFound.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player" , playerFound.getId(), playerImage);
            String image_url = base_url + image_name;
            if (team!= null){
                model.addAttribute("nameTeam",team.getName());
                model.addAttribute("is_in_team", true);
            }else{
                model.addAttribute("is_in_team", false);
            }
            if (tournament!= null){
                model.addAttribute("nameTournament",tournament.getName());
                model.addAttribute("is_in_tournament", true);
            }else{
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
            //tournament.ifPresent(value -> model.addAttribute("nameTournament", value.getName()));
            return "player";
        }


        else {
            return "404";
        }
    }









}
