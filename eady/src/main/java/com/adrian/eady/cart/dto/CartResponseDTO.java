package com.adrian.eady.cart.dto;

import java.util.Date;

import com.adrian.eady.product.Product;
import com.adrian.eady.user.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CartResponseDTO {

    private Long id;

    private Long userId;

    private ProductCartDTO product;

    private Date createdAt;

    public CartResponseDTO() {  }

    public CartResponseDTO(Long id, Long userId, ProductCartDTO product, Date createdAt ) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.createdAt = createdAt;
    }


    public Long getId(){
        return id;
    }

    public Long getUserId(){
        return userId;
    }

    public ProductCartDTO getProduct() {
        return product;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setUserId(Long newUser) {
        this.userId = newUser;
    }

    public void setProduct(ProductCartDTO newProduct) {
        this.product = newProduct;
    }

    public void setCreatedAt(Date newDate) {
        this.createdAt = newDate;
    }
}
