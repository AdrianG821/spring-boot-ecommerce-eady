package com.adrian.eady.cart.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartDeleteDTO {

    @NotNull
    @Positive    
    private Long userId;

    @NotNull
    @Positive
    private Long productId;

    public CartDeleteDTO() {}



    public Long getUserId(){
        return userId;
    }

    public Long getProductId() {
        return productId;
    }
    
    public void setUserId(Long newUserId) {
        this.userId = newUserId;
    }

    public void setProductId(Long newProductId) {
        this.productId = newProductId;
    }
}
