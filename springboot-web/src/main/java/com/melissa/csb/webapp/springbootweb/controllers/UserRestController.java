package com.melissa.csb.webapp.springbootweb.controllers;
import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.RequestMapping;





//@Controller opcional 2
@RestController // manejará  solicitudes HTTP entrantes
@RequestMapping("/api")

public class UserRestController {

  //@RequestMapping(path="/details", method = RequestMethod.GET)// mapear solicitudes HTTP GET a metodos controladores especificos en la clase opcional 2
  @GetMapping(path="/details")  
  //@ResponseBody opcional 2
                      //(Map<String, Objetct> model)
  public Map<String, Object> details(){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
    User user = new User("Melissa", "Garcia");
    Map<String, Object> body = new HashMap<>();
    body.put("title", "Hola Spring-Boot");
    body.put("user", user);
    return body;//nombre de la vista a renderizar
  }
}
