package com.adrian.eady.product;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Product getOneProduct(@PathVariable("id") int id ) {
        
        return service.getOneProduct(id);
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        //TODO: process POST request
        
        return service.addProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deteleProduct(@PathVariable("id") int id) {

        return service.deleteProduct(id);
    }
    
    
    

}
