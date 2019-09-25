package com.pc.tlal.eco.servicecatalog.service;

import com.pc.tlal.eco.servicecatalog.entity.Product;
import com.pc.tlal.eco.servicecatalog.exception.ResourceNotFoundException;
import com.pc.tlal.eco.servicecatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository
                .save(product);
    }

    @Override
    public Product read(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public List<Product> readAll(Long categoryId) {
        return productRepository
                .findProductByCategoryId(categoryId);
    }

    @Override
    public Product edit(Long id, Product product) {
        return productRepository
                .findById(id)
                .map(prod -> {
                    prod.setName(product.getName());
                    prod.setDescription(product.getDescription());
                    prod.setPrice(product.getPrice());
                    //prod.setImages(product.getImages());
                    prod.setCategory(product.getCategory());

                    return productRepository.save(prod);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", product.getId()));

    }

    @Override
    public ResponseEntity<?> remove(Long id) {

        return productRepository
                .findById(id)
                .map(product -> {
                    productRepository
                            .delete(product);

                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
    }


}
