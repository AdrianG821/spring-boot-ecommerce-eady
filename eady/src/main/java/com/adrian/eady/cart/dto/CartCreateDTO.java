package com.adrian.eady.cart.dto;

import java.sql.Date;

import com.adrian.eady.product.Product;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartCreateDTO {

    @NotNull
    @Positive    
    private Long userId;

    @NotNull
    @Positive
    private Long productId;

    private Integer  quantity;

    public CartCreateDTO() {}



    public Long getUserId(){
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    
    public void setUserId(Long newUserId) {
        this.userId = newUserId;
    }

    public void setProductId(Long newProductId) {
        this.productId = newProductId;
    }

    public void setQuantity(Integer newQuantity) {
        this.quantity = newQuantity;
    }
}
