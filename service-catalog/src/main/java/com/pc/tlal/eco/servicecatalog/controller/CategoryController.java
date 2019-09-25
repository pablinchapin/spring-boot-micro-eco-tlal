package com.pc.tlal.eco.servicecatalog.controller;

import com.pc.tlal.eco.servicecatalog.entity.Category;
import com.pc.tlal.eco.servicecatalog.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    //C
    //ToDo restricciones de acceso
    @PostMapping("addCategory")
    public Category addCategory(@Valid @RequestBody Category category){
        return categoryService.create(category);
    }

    //R
    @GetMapping("all")
    public List<Category> getAllCategories(Pageable pageable){
        return categoryService.readAll();
    }

    @GetMapping("detail/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryService.read(id);
    }

    //U
    //ToDo restricciones de acceso
    @PutMapping("edit/{id}")
    public Category editCategory(
            @PathVariable("id") Long id,
            @RequestBody Category category
    ){
        return categoryService
                .edit(id, category);
    }

    //D
    //ToDo restricciones de acceso
    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> removeCategory(
            @PathVariable("id") Long id
    ){
        return categoryService.remove(id);
    }









}
