package com.melissa.csb.webapp.springbootweb.controllers;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // manejará  solicitudes HTTP entrantes
public class UserRestController {

  @GetMapping("/details2")// mapear solicitudes HTTP GET a metodos controladores especificos en la clase
                      //(Map<String, Objetct> model)
  public Map<String, Object> details(){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
    Map<String, Object> body = new HashMap<>();
    body.put("title", "Hola Spring-Boot");
    body.put("name", "Melissa");
    body.put("lastname", "Garcia");
    return body;//nombre de la vista a renderizar
  }
}
