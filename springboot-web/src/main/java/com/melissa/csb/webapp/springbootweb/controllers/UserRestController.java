package com.melissa.csb.webapp.springbootweb.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.csb.webapp.springbootweb.dto.UserDto;
import com.melissa.csb.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.RequestMapping;





//@Controller opcional 2
@RestController // manejará  solicitudes HTTP entrantes
@RequestMapping("/api")

public class UserRestController {

  //@RequestMapping(path="/details", method = RequestMethod.GET)// mapear solicitudes HTTP GET a metodos controladores especificos en la clase opcional 2
  @GetMapping(path="/details")  
  
  
  public UserDto details(){ //objeto     
    User user = new User("Melissa", "Garcia");
    UserDto userDto= new UserDto();
    userDto.setUser(user);
    userDto.setTitle("Hola Spring-Boot");
    return userDto;//nombre de la vista a renderizar
  }

  @GetMapping("/list")
  public List <User> list(){//lista de objetos
    User user = new User("Melissa", "Garcia");
    User user2 = new User("Lina", "Marquez");
    User user3 = new User("carolina", "Narvaez");

    List <User> users = Arrays.asList(user,user2,user3);
/*  List <User> users = new ArrayList<>(); // se crea una nueva lista que contendrá los objetos de tipo User
    users.add(user);                      // se utiliza la interfaz 'List' y la implementacion concreta 'Arraylist'
    users.add(user2);
    users.add(user3); */

    return users;
    //define un método que crea tres objetos User, 
    //los agrega a una lista y luego devuelve esa lista
  }


@GetMapping(path="/details-map")  
//@ResponseBody opcional 2
                    //(Map<String, Objetct> model)
public Map<String, Object> detailsMap(){ //objeto Model como argumento que se utiliza para agregar atributos que pasaran a la vista
  User user = new User("Melissa", "Garcia");
  Map<String, Object> body = new HashMap<>();
  body.put("title", "Hola Spring-Boot");
  body.put("user", user);
  return body;//nombre de la vista a renderizar
}


}
