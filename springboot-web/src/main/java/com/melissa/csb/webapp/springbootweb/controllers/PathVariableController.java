package com.melissa.csb.webapp.springbootweb.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.melissa.csb.webapp.springbootweb.dto.ParamDto;
import com.melissa.csb.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  //escritas en application.properties

  @Value("${config.username}")
  private String username;

/*   @Value("${config.message}")
      private String message; 
*/

  @Value("${config.listOfValues}")
  private List<String> listOfValues;//automatica
  //private String [] listOfValues;
  
  @Value("${config.code}")
  private String code;
  
  @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")//string en arreglo-manual
  private List<String> valueList;
  
  @Value("#{'${config.listOfValues}'.toUpperCase()}")//string en arreglo-manual
  private String valueString;

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
  
  @GetMapping("/values")
  public  Map <String, Object> values(@Value("${config.message}") String message){
    Map <String, Object> json = new HashMap<>();
    json.put("username", username);
    json.put("code", code);
    json.put("message", message);
    json.put("listOfValues", listOfValues);
    json.put("valueList", valueList);
    json.put("valueString", valueString);
    return json;
    //localhost:8090/api/var/values
  }
  
}
