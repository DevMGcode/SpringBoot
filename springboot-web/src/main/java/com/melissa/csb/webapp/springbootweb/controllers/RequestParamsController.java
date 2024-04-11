package com.melissa.csb.webapp.springbootweb.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.dto.ParamDto;
import com.melissa.csb.webapp.springbootweb.dto.ParamMixDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/params")


public class RequestParamsController {

  @GetMapping("/foo") //recibe un parametro de tipo message de la url es obligatorio
  public ParamDto foo(@RequestParam( required = false, defaultValue = "como estas") String message){

    ParamDto param= new ParamDto();
    param.setMessage(message);
    return param;
  }
  //http://localhost:8090/api/params/foo?message=Hola

  @GetMapping("/bar")
  public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
    ParamMixDto params = new ParamMixDto();
    params.setMessage(text);
    params.setCode(code);
    return params;
  }
  //http://localhost:8090/api/params/bar?text=algun%20mensaje&code=12345
  

}
