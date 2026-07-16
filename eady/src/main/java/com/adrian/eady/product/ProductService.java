package com.adrian.eady.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    private final ProductRepository db;

    public ProductService(ProductRepository db) { this.db = db; }


    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public Optional<Product> getOneProduct(Long id) {

        
        try{
            if(id != null) {
                return db.findById(id);
            } else {
                return Optional.empty();
            }

        } catch(Exception e) {
            return Optional.empty();
        }
    }

    public Product addProduct(Product prod){
        try{

            return db.save(prod);
        } catch(Exception e) {
            return null;
        }

        // return prod;
    }

    public String deleteProduct(Long id) {

        try {

            db.deleteById(id);
            return "Product removed";

        } catch (Exception e) {
            return e.getMessage();
        }

        
    }

    public Product patchProduct(Long id, Product prod){


        try {
            Product found = db.findById(id).orElse(null);

            if(found == null){
                return null;
            }
            

            found.replaceName(prod.getName());
            found.replacePrice(prod.getPrice());
            found.replaceStock(prod.getStock());
            found.replaceDesc(prod.getDesc());


            return db.save(found);

        } catch(Exception e) {
            return null;
        }


    }

}
