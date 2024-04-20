package com.melissa.springboot.inydep.app.springbootinydep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;
import com.melissa.springboot.inydep.app.springbootinydep.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

  @Value("classpath:json/product.json")
  private Resource resource;

  @Bean("productJson")//alternativa de CmpS
  
  // Cambia el tipo de retorno a ProductRepositoryJson
  ProductRepository productRepositoryJson(){
    // Cambia la forma de instanciar ProductRepositoryJson
    return new ProductRepositoryJson(resource);
  }

}
