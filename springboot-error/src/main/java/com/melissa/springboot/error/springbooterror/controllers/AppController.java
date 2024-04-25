package com.melissa.springboot.error.springbooterror.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.melissa.springboot.error.springbooterror.models.domain.User;
import com.melissa.springboot.error.springbooterror.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

  @Autowired
  private UserService service;

  @GetMapping
  public String index(){
    //int value = 100/0;
    int value = Integer.parseInt("50x");
    System.out.println(value);
    return "ok 200";
  }

  @GetMapping("/view/{id}")
  //localhost:8080/app/view/1

  public User view(@PathVariable(name="id")Long id){
    
    User user = service.findById(id).orElseThrow(()-> new UserNotFoundException("Error el usuario no existe"));

    System.out.println(user.getLastname());
    return user;
  }
}
