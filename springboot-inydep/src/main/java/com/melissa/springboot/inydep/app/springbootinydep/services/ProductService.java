package com.melissa.springboot.inydep.app.springbootinydep.services;
import java.util.List;
import java.util.stream.Collectors;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.repositories.ProductRepository;

public class ProductService {
// Se crea una instancia del repositorio de productos para acceder a los datos
  private ProductRepository repository = new ProductRepository();
  
  // Método para obtener todos los productos
  public List<Product> findALL(){
    // Se obtiene la lista de productos del repositorio y se aplica una operación de mapeo para modificar cada producto
    return repository.findALL().stream().map( p-> {
    // Se calcula el precio con un impuesto del 25% y se establece en el producto
    Double priceImp= p.getPrice()* 1.25d;
    Product newProd= new Product(p.getId(),p.getName(),priceImp.longValue());
    //p.setPrice(priceImp.longValue());// Se establece el nuevo precio en el producto
    return  newProd;
    }).collect(Collectors.toList());// Se recolectan los productos modificados en una lista y se devuelve
  }

  public Product  findById(Long id){
    return repository.findById(id);
  }

}
