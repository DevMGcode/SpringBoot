package com.melissa.csb.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.dto.ParamDto;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
