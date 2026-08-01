package com.adrian.eady.product.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductCreateDTO {

    @NotBlank
    @Size(min = 4, max = 150)
    private     String      name;

    @Size(max = 500)
    private     String      description;

    @NotNull
    @Positive
    @DecimalMax("9999.99")
    private     Double      price;

    @NotNull
    @PositiveOrZero
    private     Integer     stock;

    @NotNull
    @Positive
    private     Long        categoryId;

    public ProductCreateDTO() {}

    public ProductCreateDTO(String name, String description, double price, int stock, Long categoryId) {
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

    public double   getPrice() {

        return  price;
    }

    public int      getStock() {

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

    public void     setPrice(double newPrice){

        this.price = newPrice;
    }

    public void     setStock(int newStock){

        this.stock = newStock;
    }
    
    public void     setCategoryId(Long newCategoryId){

        this.categoryId = newCategoryId;
    }

}
