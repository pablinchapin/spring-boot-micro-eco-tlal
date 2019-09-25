package com.pc.tlal.eco.servicecatalog.service;

import com.pc.tlal.eco.servicecatalog.entity.Category;
import com.pc.tlal.eco.servicecatalog.exception.ResourceNotFoundException;
import com.pc.tlal.eco.servicecatalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository
                .save(category);
    }

    @Override
    public Category read(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }

    @Override
    public List<Category> readAll() {
        return categoryRepository
                .findAll();
    }

    @Override
    public Category edit(Long id, Category category) {
        return categoryRepository
                .findById(id)
                .map(cat -> {
                    cat.setTitle(category.getTitle());
                    cat.setDescription(category.getDescription());
                    //cat.setImages(category.getImages());

                    return categoryRepository.save(cat);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id",  category.getId()));
    }

    @Override
    public ResponseEntity<?> remove(Long id) {
        return categoryRepository
                .findById(id)
                .map(cat -> {
                    categoryRepository
                            .delete(cat);

                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }

}
