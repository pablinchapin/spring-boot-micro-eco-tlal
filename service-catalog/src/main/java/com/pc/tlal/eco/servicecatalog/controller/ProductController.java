package com.pc.tlal.eco.servicecatalog.controller;

import com.pc.tlal.eco.servicecatalog.entity.Product;
import com.pc.tlal.eco.servicecatalog.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController {


    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    //ToDo restricciones de acceso
    //C
    @PostMapping("addProduct")
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.create(product);
    }

    //R
    @GetMapping("byCategory/{id}")
    public List<Product> getByCategory(@PathVariable("id") Long id){
        return productService.readAll(id);
    }

    @GetMapping("detail/{id}")
    public Product getByProductId(@PathVariable("id") Long id){
        return productService.read(id);
    }

    //ToDo restricciones de acceso
    //U
    @PutMapping("edit/{id}")
    public Product editProduct(
            @PathVariable("id") Long id,
            @RequestBody Product product
    ){
        return productService
                .edit(id, product);
    }


    //ToDo restricciones de acceso
    //D
    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> removeProduct(
            @PathVariable("id") Long id
    ){
        return productService.remove(id);
    }

}
