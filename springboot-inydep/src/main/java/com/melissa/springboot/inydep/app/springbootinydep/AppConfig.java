package com.melissa.springboot.inydep.app.springbootinydep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;
import com.melissa.springboot.inydep.app.springbootinydep.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

  @Bean("productJson")//alternativa de CmpS
  
  // Cambia el tipo de retorno a ProductRepositoryJson
  ProductRepository productRepositoryJson(){
    // Cambia la forma de instanciar ProductRepositoryJson
    return new ProductRepositoryJson();
  }

}
