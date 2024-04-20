package com.melissa.springboot.inydep.factura.springbootinydepfactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.springboot.inydep.factura.springbootinydepfactura.models.Invoice;

@RestController
@RequestMapping("/invoices")

public class InvoiceController {

  @Autowired
  private Invoice invoice;

  @GetMapping("/show")
  public Invoice show(){
    return invoice;
  }
}
