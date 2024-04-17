package com.melissa.springboot.inydep.app.springbootinydep.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.services.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Controller1 {
 //localhost:8080/api
  @Autowired
  private ProductServiceImpl service;

  @GetMapping
  public List<Product> list() {
    return service.findALL();
  }

  @GetMapping("/{id}")
  public Product show(@PathVariable Long id) {
    return service.findById(id);
  }
}

