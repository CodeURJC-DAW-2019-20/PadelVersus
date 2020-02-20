package com.example.padelversus.team;


import com.example.padelversus.ImageService;
import com.example.padelversus.player.Player;
import com.example.padelversus.team.display.TeamxDisplay;
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
@RequestMapping("/teamx")
public class  TeamxController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public String teamx(Model model, @PathVariable Long id) throws IOException {
        Optional<Team> team = teamRepository.findByid(id);
        if(team.isPresent()){

            TeamxDisplay teamxDisplay = new TeamxDisplay(team.get());
            Player player1  = team.get().getMemberN(1);
            Player player2 = team.get().getMemberN(2);
            BufferedImage playerImage1 = player1.getBufferedImage();
            String base_url = "/images_temp/Player/";
            String image_name = imageService.saveImage("Player", player1.getId(), playerImage1);
            String image1_url = base_url + image_name;
            player1.setImageUrl(image1_url);

            BufferedImage playerImage2 = player2.getBufferedImage();
            image_name = imageService.saveImage("Player", player2.getId(), playerImage2);
            String image2_url = base_url + image_name;
            player2.setImageUrl(image2_url);
            model.addAttribute("imageAA",image1_url);
            model.addAttribute("teamInfo", teamxDisplay);
            return "teamx";
        }else{
            return "404";

        }
    }
}
