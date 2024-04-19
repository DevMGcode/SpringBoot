package com.melissa.springboot.inydep.app.springbootinydep.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import com.melissa.springboot.inydep.app.springbootinydep.models.Product;

@Service
public class ProductServiceImpl implements ProductService{
  // Se crea una instancia del repositorio de productos para acceder a los datos
  //inyecta la instancia a la interface

  //@Autowired
  //@Qualifier("productList")
  
  //@Autowired
  //public void setRepository(ProductRepository repository) {
    //  this.repository = repository;
    //}
    
    private ProductRepository repository;
    
    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(@Qualifier("productList")ProductRepository repository) {
    this.repository = repository;
  }
    
  
  @Override
  // Método para obtener todos los productos
  public List<Product> findALL(){
    // Se obtiene la lista de productos del repositorio y se aplica una operación de mapeo para modificar cada producto
    return repository.findALL().stream().map( p-> {
    // Se calcula el precio con un impuesto del 25% y se establece en el producto
    
    Double priceTax = p.getPrice() * tax;
    //Product newProd = new Product(p.getId(),p.getName(), priceTax.longValue)
    
    Product newProd = (Product) p.clone(); // Crea una copia del producto actual para evitar modificar el original
    newProd.setPrice(priceTax.longValue()); // Establece el precio modificado en la copia del producto
    return newProd;// Devuelve la copia del producto con el precio modificado
    
    //p.setPrice(priceTax.longValue()); 
    //return p; 

    }).collect(Collectors.toList());// Se recolectan los productos modificados en una lista y se devuelve
  }


  @Override
  public Product  findById(Long id){
    return repository.findById(id);
  }


}
