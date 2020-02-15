package com.example.padelversus.user;

import com.example.padelversus.mail.NotificationService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
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
        User relatedUser = userRepository.findByName(username);
        if(relatedUser != null) {
            Player playerSave = new Player();

            playerSave.setAge(player.getAge());
            playerSave.setImage(player.getImage());
            playerSave.setCountryBirth(player.getCountryBirth());
            playerSave.setHeight(player.getHeight());
            playerSave.setWeight(player.getWeight());
            playerSave.setSpeed(player.getSpeed());
            playerSave.setStrength(player.getStrength());
            playerSave.setEndurance(player.getEndurance());
            playerSave.setPace(player.getPace());
            playerSave.setAccuaracy(player.getAccuaracy());
            playerSave.setAceleration(player.getAceleration());

            player.setUser(relatedUser);
            playerRepository.save(player);
            return "/signupSuccess";
        }
        return "404";
    }

    /*public String crear(@RequestParam String name, String pass, BindingResult bindingResult, ModelMap mp) {
        userRepository.save(new User(name,pass,"ROLE_USER"));
        System.out.println("Crear");
        /*if (bindingResult.hasErrors()) {
            System.out.println("HAY ERROR");
            return "/crud/nuevo";
        } else {
            userRepository.save(user);
            mp.put("usuario", user);
            return "/";
        }
        return "/";
    }*/


}