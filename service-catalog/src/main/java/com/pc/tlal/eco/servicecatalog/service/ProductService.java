package com.pc.tlal.eco.servicecatalog.service;

import com.pc.tlal.eco.servicecatalog.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product read(Long id);
    List<Product> readAll(Long categoryId);
    Product edit(Long id, Product product);
    ResponseEntity<?> remove(Long id);


}
