package com.melissa.csb.webapp.springbootweb.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.csb.webapp.springbootweb.dto.ParamDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {
  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable String message){
    ParamDto param= new ParamDto();
    param.setMessage(message);
    return param;
    //http://localhost:8090/api/var/baz/mesa
    //más estandar el parametro en la ruta
  } 
}
