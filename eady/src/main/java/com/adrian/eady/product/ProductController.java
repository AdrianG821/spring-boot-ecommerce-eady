package com.adrian.eady.product;

import org.springframework.web.bind.annotation.RestController;

import com.adrian.eady.product.dto.ProductCreateDTO;
import com.adrian.eady.product.dto.ProductResponseDTO;
import com.adrian.eady.product.dto.ProductUpdateDTO;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        List<ProductResponseDTO> products = service.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(products);


    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> getOneProduct(@PathVariable("id") Long id ) {
        
        ProductResponseDTO product = service.getOneProduct(id);

        if(product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/product/add")
    public ResponseEntity<ProductResponseDTO> addProduct(@Valid @RequestBody ProductCreateDTO product) {
        //TODO: process POST request
        
        ProductResponseDTO prod = service.addProduct(product);

        if(prod != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(prod);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<String> deteleProduct(@PathVariable("id") Long id) {

        String response = service.deleteProduct(id);

        if(response.equals("Product removed")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/product/patch/{id}")
    public ResponseEntity<ProductResponseDTO> patchProduct(@PathVariable("id") Long id,@Valid @RequestBody ProductUpdateDTO product) {

        ProductResponseDTO prod = service.patchProduct(id, product);

        if(prod != null) {
            return ResponseEntity.ok(prod);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    

}
