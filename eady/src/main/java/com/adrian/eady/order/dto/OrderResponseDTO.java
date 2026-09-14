package com.adrian.eady.order.dto;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderResponseDTO {

    private Long id;
    private String paymentForm;
    private String address;
    private Double totalPrice;

    private Boolean active;

    private Date createdAt;
    

    public OrderResponseDTO() {}

    public OrderResponseDTO(Long id, String paymentForm, String address, Double totalPrice, Boolean active, Date createdAt) {
        this.id                    = id;
        this.paymentForm           = paymentForm;
        this.address               = address;
        this.totalPrice            = totalPrice;
        this.active                = active;
        this.createdAt             = createdAt;
    }

    public Long getId(){
        return id;
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public String getAddress() {
        return address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
    

    public Boolean getActive() {
        return active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setPaymentForm(String paymentForm){
        this.paymentForm = paymentForm;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }


    public void setActive(Boolean active){
        this.active = active;
    }
    
}
