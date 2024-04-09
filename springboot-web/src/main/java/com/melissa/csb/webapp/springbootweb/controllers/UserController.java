package com.melissa.csb.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melissa.csb.webapp.springbootweb.models.User;

@Controller // manejará  solicitudes HTTP entrantes
public class UserController {

  @GetMapping("/details")// mapear solicitudes HTTP GET a metodos controladores especificos en la clase
                      //(Map<String, Objetct> model)
  public String details(Model model){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
    User user = new User("Melissa", "Garcia");
    model.addAttribute("title", "Hola Spring-Boot");
    model.addAttribute("user", user);
    return "details";//nombre de la vista a renderizar
  }
}
