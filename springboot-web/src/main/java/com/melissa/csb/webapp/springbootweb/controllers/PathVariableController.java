package com.melissa.csb.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.dto.ParamDto;
import com.melissa.csb.webapp.springbootweb.models.User;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable String message) {
    ParamDto param = new ParamDto();
    param.setMessage(message);
    return param;
    // http://localhost:8090/api/var/baz/mesa
    // más estandar el parametro en la ruta
  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id", id );

    return json;
    //http://localhost:8090/api/var/mix/mouse/25
  }

  @PostMapping("/create")
  public User create(@RequestBody User user){
    //Realizar con el usuario y guardar en la bd
    user.setName(user.getName().toUpperCase());
    return user;
  } 

/*  
  VALIDACION EN POSTMAN SOBRE EL POST -body-raw-json
  localhost:8090/api/var/create
  {
    "name": "Meli",
    "lastname": "Garcia",
    "email": "mg12dolce@gmail.com"
  } 
  
*/
  

}
