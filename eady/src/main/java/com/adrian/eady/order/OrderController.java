package com.adrian.eady.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.eady.order.dto.OrderCreateDTO;
import com.adrian.eady.order.dto.OrderResponseDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {this.service = service;}


    @GetMapping("/get/all/{id}")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders(@PathVariable ("id") Long userId) {
        List<OrderResponseDTO> orders = service.getAllOrders(userId);

        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create/order")
    public ResponseEntity<Long> createOrder(@Valid @RequestBody OrderCreateDTO create) {
        //TODO: process POST request
        
        return ResponseEntity.ok(service.createOrder(create));
    }

    @PostMapping("/cancel/order/{id}") 
    public ResponseEntity<String> cancelOrder(@RequestParam("id") Long id) {
        //TODO: process POST request
        
        return ResponseEntity.ok(service.cancelOrder(id));
    }
    
    
    
    
    
}
