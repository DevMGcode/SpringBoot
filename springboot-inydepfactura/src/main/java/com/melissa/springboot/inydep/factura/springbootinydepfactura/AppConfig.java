package com.melissa.springboot.inydep.factura.springbootinydepfactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.melissa.springboot.inydep.factura.springbootinydepfactura.models.Item;
import com.melissa.springboot.inydep.factura.springbootinydepfactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

  @Bean
  //@Primary
  List<Item>itemsInvoice(){ // lo que devuelva se guarda como componente de spring
    Product p1 = new Product("Cámara Sony", 800);
    Product p2 = new Product("Bicicleta Bianchi 27", 1500);
    Item item1 = new Item(p1, 2);
    Item item2 = new Item(p2, 4);
    return Arrays.asList(item1, item2);
  }

  @Bean("default") 
  List<Item>itemsInvoiceoffice(){ // lo que devuelva se guarda como componente de spring
    Product p1 = new Product("Monitor samsung 32", 700);
    Product p2 = new Product("Notebook Lenovo", 2300);
    Product p3 = new Product("Impresora Hp", 900);
    Product p4 = new Product("Escritorio Oficina", 950);
    Item item1 = new Item(p1, 4);
    Item item2 = new Item(p2, 6);
    Item item3 = new Item(p3, 1);
    Item item4 = new Item(p4, 4);
    return Arrays.asList(item1, item2,item3,item4);
  }
}
