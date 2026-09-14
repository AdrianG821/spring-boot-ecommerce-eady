package com.adrian.eady.order.dto;

public class OrderCreateDTO {

    
    private String paymentForm;
    private String address;
    private Double totalPrice;

    private Integer quantity;

    private Long userId;

    

    public OrderCreateDTO() {}

    public OrderCreateDTO(String paymentForm, String address, Double totalPrice,Long userId, Integer quantity) {
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
