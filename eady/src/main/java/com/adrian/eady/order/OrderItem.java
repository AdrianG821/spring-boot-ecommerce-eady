package com.adrian.eady.order;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.adrian.eady.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity 
@Table (name = "orderitem")
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

    private Integer quantity;

    @CreationTimestamp
    private Date createdAt;
    

    public OrderItem() {}

    public OrderItem(Order order,Double orderedPrice,Product product, Integer quantity) {
        this.order             = order;
        this.orderedPrice      = orderedPrice;
        this.product           = product;
        this.quantity          = quantity;
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

    public Integer getQuantity() {
        return quantity;
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

    public void setProduct(Product product){
        this.product = product;
    }

    public void setQuantity(Integer newQuantity) {
        this.quantity = newQuantity;
    }
    
}
