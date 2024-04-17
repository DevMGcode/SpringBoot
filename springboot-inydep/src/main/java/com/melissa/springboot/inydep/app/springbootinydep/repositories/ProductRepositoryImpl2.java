package com.melissa.springboot.inydep.app.springbootinydep.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.melissa.springboot.inydep.app.springbootinydep.models.Product;
import com.melissa.springboot.inydep.app.springbootinydep.services.ProductRepository;


@Repository
public class ProductRepositoryImpl2 implements ProductRepository {

  @Override
  public List<Product> findALL() {
    // Lógica para recuperar todos los productos desde algún origen de datos
    return Collections.singletonList(new Product(1L,"Monitor Samsung 27",600L));
  }

  @Override
  public Product findById(Long id) {
    // Lógica para recuperar un producto por su ID desde algún origen de datos
    return new Product(id,"Monitor Samsung 27",600L);
  }

}
