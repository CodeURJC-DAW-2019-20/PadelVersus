package com.example.padelversus.user;

import com.example.padelversus.mail.NotificationService;
import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository uc;

    @Autowired
    private PlayerRepository pc;
    @Autowired
    private NotificationService notificationService;


    @PostMapping("/saveUser")
    public String saveUser(User user){
        //user.setRol("ROLE_USER");
        //User u = uc.save(user);
        //return "/";
        User u = uc.findByName(user.getName());
        if (u == null) {
            User userSave = new User();
            userSave.setName(user.getName());
            userSave.setPasswordHash(user.getPasswordHash());
            userSave.setMail(user.getMail());
            userSave.setRol("USER_ROLE");
            uc.save(userSave);
            notificationService.sendNotification(user);
            //updateTabs(model);
            return "/signupPlayer";
        }

        return "404";
    }

    @PostMapping("/signupPlayer")
    public String signupPlayer(Player player){
        pc.save(player);
        return "/signupSuccess";
    }

    /*public String crear(@RequestParam String name, String pass, BindingResult bindingResult, ModelMap mp) {
        uc.save(new User(name,pass,"ROLE_USER"));
        System.out.println("Crear");
        /*if (bindingResult.hasErrors()) {
            System.out.println("HAY ERROR");
            return "/crud/nuevo";
        } else {
            uc.save(user);
            mp.put("usuario", user);
            return "/";
        }
        return "/";
    }*/


}