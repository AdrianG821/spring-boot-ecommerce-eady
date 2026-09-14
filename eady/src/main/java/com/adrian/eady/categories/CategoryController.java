package com.adrian.eady.categories;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.eady.categories.dto.CategoryResponseDTO;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<CategoryResponseDTO> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable("id") Long id) {
        return service.getCategoryById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewCategory(@RequestBody String name) {
        //TODO: process POST request
        if(name == null || name == ""){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide a valid name for the category!");
        }
        String response = service.addNewCategory(name);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id){
        return service.deleteCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategoryById(@PathVariable("id") Long id) {
        //TODO: process PUT request
        
        String response = service.updateCategoryById(id);

        return ResponseEntity.ok(response);
    }
}
