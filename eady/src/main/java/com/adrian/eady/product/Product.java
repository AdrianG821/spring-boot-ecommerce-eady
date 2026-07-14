package com.adrian.eady.product;

public class Product {
    private long id;
    private String name;
    private String desc;
    private double price;
    private int stock;

    public Product(long id, String name, String desc, double price, int stock) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock = stock;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void replaceName(String newName){
        this.name = newName;
    }

    public void replaceDesc(String newDesc){
        this.desc = newDesc;
    }

    public void replacePrice(double newPrice){
        this.price = newPrice;
    }

    public void replaceStock(int newStock){
        this.stock = newStock;
    }
}
