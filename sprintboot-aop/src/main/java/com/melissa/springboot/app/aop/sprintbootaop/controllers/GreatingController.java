package com.melissa.springboot.app.aop.sprintbootaop.controllers;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService;

@RestController
public class GreatingController {

  @Autowired
  private GreetingService greetingService;

  @GetMapping("/greeting")
  public ResponseEntity <?> greeting(){

    return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Meli", "Hola que tal!")));
  }
  @GetMapping("/greeting-error")
  public ResponseEntity <?> greetingError(){

    return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Meli", "Hola que tal!")));
  }
}
