package com.adrian.eady.order;


import java.util.Date;

import com.adrian.eady.user.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentForm;
    private String address;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private Boolean active;

    private Date createdAt;
    

    public Order() {}

    public Order(String paymentForm, String address, Double totalPrice, User user ,Boolean active) {
        this.paymentForm           = paymentForm;
        this.address               = address;
        this.totalPrice            = totalPrice;
        this.user                  = user;
        this.active                = active;
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
    
    public User getUser() {
        return user;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getCreatedAt() {
        return createdAt;
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

    public void setUser(User user){
        this.user = user;
    }

    public void setActive(Boolean active){
        this.active = active;
    }
    

}
