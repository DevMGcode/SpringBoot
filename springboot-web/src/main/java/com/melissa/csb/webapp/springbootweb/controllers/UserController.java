package com.melissa.csb.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // manejará  solicitudes HTTP entrantes
public class UserController {

  @GetMapping("/details")// mapear solicitudes HTTP GET a metodos controladores especificos en la clase
                      //(Map<String, Objetct> model)
  public String details(Model model){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
    model.addAttribute("title", "Hola Spring-Boot");
    model.addAttribute("name", "Melissa");
    model.addAttribute("lastname", "Garcia");
    return "details";//nombre de la vista a renderizar
  }
}
