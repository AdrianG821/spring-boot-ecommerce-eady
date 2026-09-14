package com.adrian.eady.order;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.adrian.eady.product.Product;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Double orderedPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @CreationTimestamp
    private Date createdAt;
    

    public OrderItem() {}

    public OrderItem(Order order,Double orderedPrice,Product product) {
        this.order             = order;
        this.orderedPrice      = orderedPrice;
        this.product           = product;
    }

    public Long getId(){
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Double getOrderedPrice() {
        return orderedPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setOrderedPrice(Double orderedPrice){
        this.orderedPrice = orderedPrice;
    }

    public void setName(Product product){
        this.product = product;
    }
    
}
