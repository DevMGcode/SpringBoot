package com.melissa.springboot.inydep.app.springbootinydep.repositories;
import java.util.Arrays;
import java.util.List;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;

public class ProductRepository {
  // Lista que almacena los productos
  private List<Product> data;

  // Constructor de la clase que inicializa la lista 'data' con algunos productos
  public ProductRepository() {
    this.data=Arrays.asList(new Product(1L,"Memoria Kinstom 54",300L),
    new Product(2L,"CPU intel core i9",850L),
    new Product(3L,"Teclado Racer",180L),
    new Product(4L,"Lapto Lenovo",490L));
  }
  
  // Método para obtener todos los productos en el repositorio
  public List<Product> findALL(){
    return data;
  }

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
