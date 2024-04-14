package com.melissa.csb.webapp.springbootweb.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
  @GetMapping({"","/","/home"})
  public String home (){
    return "redirect:/list"; // "redirect:/list" reinicia el request -"forward:/list" por el metodo handler despacha(incluide) y se mantiene el request
  }
}
