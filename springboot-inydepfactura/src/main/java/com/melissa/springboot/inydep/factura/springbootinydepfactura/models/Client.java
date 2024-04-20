package com.melissa.springboot.inydep.factura.springbootinydepfactura.models;

import org.springframework.stereotype.Component;

@Component
public class Client {
  
  private String name;
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
