package com.adrian.eady.product.dto;

public class ProductCreateDTO {
    private String  name;
    private String  description;
    private double  price;
    private int     stock;
    private Long     categoryId;

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
