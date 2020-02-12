package com.example.padelversus.user;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp) {
        mp.put("usuarios", uc.findAll());
        return "crud/lista";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(ModelMap mp) {
        mp.put("usuario", new User());
        return "crud/nuevo";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String crear(@RequestParam User user) {
        uc.save(user);

        return "/";
    }

    @PostMapping("/saveUser")
    public String saveUser(Model model, User user){
        //user.setRol("ROLE_USER");
        User u = uc.save(user);
        return "/";
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

    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("usuario") User user) {
        return "/crud/creado";
    }

}