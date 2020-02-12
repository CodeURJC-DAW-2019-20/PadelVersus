package com.example.padelversus;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private Logger logger = LoggerFactory.getLogger(PlayerController.class);
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{id}")
    public String player(Model model, @PathVariable Long id){
            Optional<Player> player = playerRepository.findById(id);
            if (player.isPresent()) {
                model.addAttribute("name", player.get().getUsername());
                return "player";
            } else {
                return "404";
            }
    }

    @RequestMapping("/signup")
    public String signupSuccess(){
        Player player = new Player("Dan",5,"alexcheca.98@gmail.com");

        try{
            notificationService.sendNotification(player);
        }catch (MailException e){
            logger.info("Error email:" + e.getMessage());
        }
        return "404";
    }

    @GetMapping("/teamxtest")
    public String teamx(){
        return "teamx";
    }

    @GetMapping("/overviewtest")
    public String overview(){
        return "overviewMatches";
    }

    @GetMapping("/s")
    public String s(){
        return "standings";
    }
    @GetMapping("/teamstest")
    public String teams(){
        return "teams";
    }

    @GetMapping("/cal")
    public String cal(){
        return "calendar";
    }

    @GetMapping("/rf")
    public String rf(){
        return "RegistrationForm";
    }

    @GetMapping("/matches")
    public String matches(){
        return "matches";
    }

}
