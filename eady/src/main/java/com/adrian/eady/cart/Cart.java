package com.adrian.eady.cart;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.adrian.eady.product.Product;
import com.adrian.eady.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @CreationTimestamp
    private Date createdAt;

    public Cart() {}


    public Long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setUser(User newUser) {
        this.user = newUser;
    }

    public void setProduct(Product newProduct) {
        this.product = newProduct;
    }

}
