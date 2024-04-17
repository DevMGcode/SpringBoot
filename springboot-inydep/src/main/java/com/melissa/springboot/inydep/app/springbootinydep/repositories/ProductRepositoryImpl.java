package com.melissa.springboot.inydep.app.springbootinydep.repositories;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.annotation.SessionScope;

import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;

@SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{
  // Lista que almacena los productos
  private List<Product> data;

  // Constructor de la clase que inicializa la lista 'data' con algunos productos
  public ProductRepositoryImpl() {
    this.data=Arrays.asList(new Product(1L,"Memoria Kinstom 54",300L),
    new Product(2L,"CPU intel core i9",850L),
    new Product(3L,"Teclado Racer",180L),
    new Product(4L,"Lapto Lenovo",490L));
  }
  
  @Override
  // Método para obtener todos los productos en el repositorio
  public List<Product> findALL(){
    return data;
  }

  @Override
  public Product findById(Long id){
    // Inicia un flujo sobre la lista de productos 'data'
    return data.stream()
    // Aplica un filtro para seleccionar solo aquellos productos cuyo ID coincide con el proporcionado
    .filter(p-> p.getId().equals(id))
     // Busca el primer elemento que coincide con el filtro aplicado
    .findFirst()
    // Obtiene el valor contenido si está presente, o devuelve null si está vacío
    .orElse(null);
  }

}
