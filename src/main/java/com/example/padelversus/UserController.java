package com.example.padelversus;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crud")
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

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crear(@Valid User user, BindingResult bindingResult, ModelMap mp) {
        System.out.println("Crear");
        if (bindingResult.hasErrors()) {
            System.out.println("HAY ERROR");
            return "/crud/nuevo";
        } else {
            uc.save(user);
            mp.put("usuario", user);
            return "/";
        }
    }

    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("usuario") User user) {
        return "/crud/creado";
    }

}