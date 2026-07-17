package com.adrian.eady.product;
import com.adrian.eady.categories.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {}

    public Product(String name, String desc, double price, int stock) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.stock = stock;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Category getCategory(){
        return category;
    }

    public void replaceName(String newName){
        this.name = newName;
    }

    public void replaceDesc(String newDesc){
        this.description = newDesc;
    }

    public void replacePrice(double newPrice){
        this.price = newPrice;
    }

    public void replaceStock(int newStock){
        this.stock = newStock;
    }
    
    public void setCategory(Category newCategory){
        this.category = newCategory;
    }
}
