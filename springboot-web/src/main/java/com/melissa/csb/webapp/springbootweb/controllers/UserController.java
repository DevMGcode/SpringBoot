package com.melissa.csb.webapp.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.melissa.csb.webapp.springbootweb.models.User;



@Controller // manejará  solicitudes HTTP entrantes
public class UserController {

  @GetMapping("/details")// mapear solicitudes HTTP GET a metodos controladores especificos en la clase
                      //(Map<String, Objetct> model)
  public String details(Model model){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
    User user = new User("Melissa", "Garcia");
    user.setEmail("Meligarcia@gmail.com");
    model.addAttribute("title", "Hola Spring-Boot");
    model.addAttribute("user", user);
    return "details";//nombre de la vista a renderizar
  }

  @GetMapping("/list")
  public String list (ModelMap model) {
    List<User> users = new ArrayList<>();
    model.addAttribute("users",users);
    model.addAttribute("title", "listado de usuarios");   
    /* model.addAttribute("title","listado de usuarios"); */
    return "list";
  }
  

}


