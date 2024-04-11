package com.melissa.csb.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.melissa.csb.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Melissa", "Garcia");
        user.setEmail("Meligarcia@gmail.com");
        model.addAttribute("title", "Hola Spring-Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
     /*    List<User> users = Arrays.asList(
            new User("Meli", "Garcia","mg@gmail.com"),
            new User("Fede", "gonzalez"),
            new User("Juliana", "Hernandez","JH@gmail.com"),
            new User("Sebastian", "Benavidez")
        ); */

        //model.addAttribute("users", users);
        model.addAttribute("title", "listado de usuarios");
        return "list";    
    }

    @ModelAttribute("users")//se guarda en la vista
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Meli", "Garcia","mg@gmail.com"),
            new User("Fede", "gonzalez"),
            new User("Juliana", "Hernandez","JH@gmail.com"),
            new User("Sebastian", "Benavidez"));           
    }
}


