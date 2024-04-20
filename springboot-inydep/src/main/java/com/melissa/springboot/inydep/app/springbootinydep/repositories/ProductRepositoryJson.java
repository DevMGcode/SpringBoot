package com.melissa.springboot.inydep.app.springbootinydep.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;

public class ProductRepositoryJson implements ProductRepository {

  private List<Product> list; // Declara una lista de productos

  

  // Constructor de la clase ProductRepositoryJson
  public ProductRepositoryJson(){
    
    Resource resource = new ClassPathResource("json/product.json");
    readValueJson(resource);  
  }

  public ProductRepositoryJson(Resource resource){
    readValueJson(resource);
  }

  public void readValueJson(Resource resource){
    ObjectMapper objectMapper = new ObjectMapper(); 
    try {
    
      list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
    } catch (IOException e) { 
      e.printStackTrace(); 
    }
  }

  // Implementación del método definido en la interfaz ProductRepository para obtener todos los productos
  @Override
  public List<Product> findALL() {
    return list; // Devuelve la lista de productos
  }

  // Implementación del método definido en la interfaz ProductRepository para obtener un producto por su id
  @Override
  public Product findById(Long id) {
    // Busca el primer producto cuyo id coincida con el id proporcionado, o lanza una excepción si no se encuentra ninguno
    return list.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow();
  }

}
