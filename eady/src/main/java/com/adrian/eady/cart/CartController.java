package com.adrian.eady.cart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.eady.cart.dto.CartCreateDTO;
import com.adrian.eady.cart.dto.CartDeleteDTO;
import com.adrian.eady.cart.dto.CartResponseDTO;

import jakarta.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService service;

    public CartController(CartService service) {this.service = service;}


    @GetMapping("/get/products/{id}")
    public ResponseEntity<List<CartResponseDTO>> getCart(@PathVariable("id") Long id) {
        List<CartResponseDTO> cart = service.getCart(id);

        return ResponseEntity.ok(cart);
    }

    @PostMapping("/insert/product")
    public ResponseEntity<String> addCartProduct(@Valid @RequestBody CartCreateDTO cart) {
        //TODO: process POST request
        String response = service.addCartProduct(cart);
        
        if(response == "ok"){
            ResponseEntity.ok();
        } else if(response == "User not found"){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not added");
        }
    }

    @PostMapping("/delete/product")
    public ResponseEntity<String> removeCartProduct(@RequestBody CartDeleteDTO dto) {
        //TODO: process POST request
        
        return ResponseEntity.ok(service.removeCartProduct(dto));
    }

    
    
    
    
}
