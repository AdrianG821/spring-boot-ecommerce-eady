package com.adrian.eady.cart.dto;

public class ProductCartDTO {

    private Long    id;
    private String  name;
    private double  price;
    private String  categoryName; 

    public ProductCartDTO() {}

    public ProductCartDTO(Long id,String name,  double price,  String categoryName) {
        this.id              = id;
        this.name            = name;
        this.price           = price;
        this.categoryName    = categoryName;
    }

    public Long     getId(){
        
        return  id;
    }

    public String   getName() {

        return  name;
    }


    public double   getPrice() {

        return  price;
    }

    public String   getCategoryName() {

        return  categoryName;
    }

    public void     setId(Long id) {

        this.id = id;
    }


    public void     setName(String newName){

        this.name = newName;
    }

    public void     setPrice(double newPrice){

        this.price = newPrice;
    }


    public void     setCategoryName(String newCategoryName){

        this.categoryName = newCategoryName;
    }
}
