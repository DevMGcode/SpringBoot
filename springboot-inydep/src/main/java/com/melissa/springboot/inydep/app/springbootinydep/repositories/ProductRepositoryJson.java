package com.melissa.springboot.inydep.app.springbootinydep.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;

public class ProductRepositoryJson implements ProductRepository {

  private List<Product> list; // Declara una lista de productos

  // Constructor de la clase ProductRepositoryJson
  public ProductRepositoryJson(){
    // Obtiene una referencia al archivo de recursos "product.json" en el directorio de recursos
    Resource resource = new ClassPathResource("json/product.json");
    // Crea un ObjectMapper, que se utiliza para leer y escribir JSON
    ObjectMapper objectMapper = new ObjectMapper(); 
    try {
      // Lee el contenido del archivo JSON y lo mapea a un array de objetos de tipo Product
      list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    } catch (StreamReadException e) { // Captura excepciones relacionadas con la lectura del flujo de entrada
      e.printStackTrace(); // Imprime la traza de la excepción en la consola
    } catch (DatabindException e) { // Captura excepciones relacionadas con el mapeo de datos
      e.printStackTrace(); // Imprime la traza de la excepción en la consola
    } catch (IOException e) { // Captura excepciones de entrada/salida
      e.printStackTrace(); // Imprime la traza de la excepción en la consola
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
