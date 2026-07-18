package com.adrian.eady.product.dto;

public class ProductResponseDTO {
    private Long    id;
    private String  name;
    private String  description;
    private double  price;
    private int     stock;
    private Long    categoryId;
    private String  categoryName; 

    public ProductResponseDTO() {}

    public ProductResponseDTO(Long id,String name, String description, double price, int stock, Long categoryId, String categoryName) {
        this.id              = id;
        this.name            = name;
        this.description     = description;
        this.price           = price;
        this.stock           = stock;
        this.categoryId      = categoryId;
        this.categoryName    = categoryName;
    }

    public Long     getId(){
        
        return  id;
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

    public String   getCategoryName() {

        return  categoryName;
    }

    public void     setId(Long id) {

        this.id = id;
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

    public void     setCategoryName(String newCategoryName){

        this.categoryName = newCategoryName;
    }
}
