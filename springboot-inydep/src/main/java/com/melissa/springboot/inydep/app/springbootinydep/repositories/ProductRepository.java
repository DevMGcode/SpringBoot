package com.melissa.springboot.inydep.app.springbootinydep.repositories;

import java.util.Arrays;
import java.util.List;

import com.melissa.springboot.inydep.app.springbootinydep.models.Product;

public class ProductRepository {
  private List<Product> data;

  public ProductRepository() {
    this.data=Arrays.asList(new Product(1L,"Memoria Kinstom 54",300L),
    new Product(2L,"CPU intel core i9",850L),
    new Product(3L,"Teclado Racer",180L),
    new Product(4L,"Lapto Lenovo",490L));
  }
  
  public List<Product> findALL(){
    return data;
  }

}
