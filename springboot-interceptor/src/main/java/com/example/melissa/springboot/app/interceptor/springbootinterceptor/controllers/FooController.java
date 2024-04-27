package com.example.melissa.springboot.app.interceptor.springbootinterceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FooController {

  @GetMapping("/foo")
  public Map<String, String> foo(){
    return Collections.singletonMap("message","handler foo controlador");
  }

  @GetMapping("/bar")
  public Map<String, String> bar(){
    return Collections.singletonMap("message","handler foo controlador");
  }

  @GetMapping("/bax")
  public Map<String, String> bax(){
    return Collections.singletonMap("message","handler foo controlador");
  }

  
}
