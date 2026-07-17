package com.adrian.eady.categories;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




//De modificat ProductController ca requestmapping sa fie api/product

@RestController()
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService service;
    
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/get/all")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") Long id) {
        return service.getCategoryById(id);
    }

    @PostMapping("/add")
    public Category addNewCategory(@RequestBody Category cat) {
        //TODO: process POST request
        
        return service.addNewCategory(cat);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id){
        return service.deleteCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public Category updateCategoryById(@PathVariable("id") Long id, @RequestBody Category cat) {
        //TODO: process PUT request
        
        return service.updateCategoryById(id, cat);
    }
    
    
}
