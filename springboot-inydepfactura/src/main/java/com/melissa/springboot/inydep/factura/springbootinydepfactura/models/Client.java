package com.melissa.springboot.inydep.factura.springbootinydepfactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource","advisors"})
public class Client {
  @Value("${client.name}")
  private String name;
  @Value("${client.lastname}")
  private String lastaname;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLastaname() {
    return lastaname;
  }
  public void setLastaname(String lastaname) {
    this.lastaname = lastaname;
  }
  
}
