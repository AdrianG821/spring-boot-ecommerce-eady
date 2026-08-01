package com.adrian.eady.product.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductUpdateDTO {
    
    @Size(min = 4, max = 150)
    private String  name;

    @Size(max = 500)
    private String  description;

    @Positive
    @DecimalMax("9999.99")  
    private Double  price;

    @PositiveOrZero
    private Integer stock;
    
    @Positive
    private Long    categoryId;

    public ProductUpdateDTO() {}

    public ProductUpdateDTO(String name, String description, Double price, Integer stock, Long categoryId) {
        this.name            = name;
        this.description     = description;
        this.price           = price;
        this.stock           = stock;
        this.categoryId      = categoryId;
    }


    public String   getName() {

        return  name;
    }

    public String   getDescription() {

        return  description;
    }

    public Double   getPrice() {

        return  price;
    }

    public Integer  getStock() {

        return  stock;
    }

    public Long     getCategoryId(){

        return  categoryId;
    }




    public void     setName(String newName){

        this.name = newName;
    }

    public void     setDescription(String newDesc){

        this.description = newDesc;
    }

    public void     setPrice(Double newPrice){

        this.price = newPrice;
    }

    public void     setStock(Integer newStock){

        this.stock = newStock;
    }
    
    public void     setCategoryId(Long newCategoryId){

        this.categoryId = newCategoryId;
    }


}
