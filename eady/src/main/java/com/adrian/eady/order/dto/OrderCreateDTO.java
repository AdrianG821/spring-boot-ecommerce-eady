package com.adrian.eady.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderCreateDTO {

    @NotBlank 
    private String paymentForm;

    @NotBlank
    private String address;

    @NotNull 
    @Positive
    private Long userId;

    

    public OrderCreateDTO() {}

    public OrderCreateDTO(String paymentForm, String address,Long userId) {
        this.paymentForm           = paymentForm;
        this.address               = address;
        this.userId                = userId;
    }



    public String getPaymentForm() {
        return paymentForm;
    }

    public String getAddress() {
        return address;
    }
    
    public Long getUserId() {
        return userId;
    }


    public void setPaymentForm(String paymentForm){
        this.paymentForm = paymentForm;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

}
