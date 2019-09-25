package com.pc.tlal.eco.servicecatalog.service;

import com.pc.tlal.eco.servicecatalog.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    Category create(Category category);
    Category read(Long id);
    List<Category> readAll();
    Category edit(Long id, Category category);
    ResponseEntity<?> remove(Long id);

}
