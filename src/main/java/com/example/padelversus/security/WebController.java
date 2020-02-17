package com.example.padelversus.security;

import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }
    @RequestMapping("/createuser")
    public String createuser(){
        userRepository.save(new User("user2", "pass","user@gmail.com", "ROLE_USER"));
        return "createuser";
    }
    @RequestMapping("/loginerror")
    public String loginerror(){
        return "loginerror"; //Ver como manejamos el error en el logIn
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
  /* @Autowired
   private UserComponent userComponent;

    @ModelAttribute
    public void addUserToModel(Model model) {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);
        if(logged) {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
            model.addAttribute("userName",userComponent.getLoggedUser().getName());
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("hideLogin", true);
        return "login";
    }

    @GetMapping("/loginerror")
    public String loginError() {
        return "loginerror";
    }*/
}
