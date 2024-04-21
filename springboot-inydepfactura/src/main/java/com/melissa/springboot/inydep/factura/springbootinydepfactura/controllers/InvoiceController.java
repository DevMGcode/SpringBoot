package com.melissa.springboot.inydep.factura.springbootinydepfactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melissa.springboot.inydep.factura.springbootinydepfactura.models.Client;
import com.melissa.springboot.inydep.factura.springbootinydepfactura.models.Invoice;

@RestController
@RequestMapping("/invoices")

public class InvoiceController {

  @Autowired
  private Invoice invoice;

  @GetMapping("/show")
  public Invoice show(){
    Invoice i = new Invoice();
    Client c= new Client();
    c.setLastaname(invoice.getClient().getLastaname());
    c.setName(invoice.getClient().getName());
    i.setClient(c);
    i.setDescription(invoice.getDescription());
    i.setItems(invoice.getItems());
    return i;
  }
}
