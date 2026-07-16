package com.adrian.eady.product;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService service;
    
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getOneProduct(@PathVariable("id") Long id ) {
        
        return service.getOneProduct(id);
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        //TODO: process POST request
        
        return service.addProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deteleProduct(@PathVariable("id") Long id) {

        return service.deleteProduct(id);
    }

    @PutMapping("/product/patch/{id}")
    public Product patchProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return service.patchProduct(id, product);
    }
    
    
    

}
