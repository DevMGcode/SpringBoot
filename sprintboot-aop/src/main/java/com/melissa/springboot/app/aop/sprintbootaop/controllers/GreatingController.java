package com.melissa.springboot.app.aop.sprintbootaop.controllers;


import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreatingController {

  @GetMapping("/greeting")
  public ResponseEntity <?> greeting(){

    return ResponseEntity.ok(Collections.singletonMap("greeting", null));
  }
}
