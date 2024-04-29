package com.example.melissa.springboot.calendar.interceptor.springboothorario.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {

//localhost:8080/foo
  @GetMapping("/foo")
  public ResponseEntity<?> foo(HttpServletRequest request){    
    Map<String, Object> data= new HashMap<>();
    data.put("title","Bienvenidos al sistema de atencion!");
    data.put("time",new Date());
    data.put("message", request.getAttribute("message"));
    return ResponseEntity.ok(data);
  }
}
