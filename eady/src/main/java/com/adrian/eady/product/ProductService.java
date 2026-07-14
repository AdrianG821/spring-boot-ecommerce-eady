package com.adrian.eady.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    private List<Product> products ;

    public ProductService(){
        products = new ArrayList<>();

        products.add(new Product(1, "Iphone 16 PRO MAX", "This is a phone", 1200, 25)) ;
        products.add(new Product(2, "Iphone 17 PRO MAX", "This is a phone", 1500, 55));
        products.add(new Product(3, "Iphone 11 PRO MAX", "This is a phone", 600, 11));
    }


    public List<Product> getAllProducts(){
        return products;
    }

    public Product getOneProduct(int id) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }

        return null;
    }

}
