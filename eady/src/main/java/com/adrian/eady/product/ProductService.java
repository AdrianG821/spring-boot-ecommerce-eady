package com.adrian.eady.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.eady.categories.Category;
import com.adrian.eady.categories.CategoryRepository;
import com.adrian.eady.product.dto.ProductCreateDTO;
import com.adrian.eady.product.dto.ProductResponseDTO;
import com.adrian.eady.product.dto.ProductUpdateDTO;




@Service
public class ProductService {
    
    private final ProductRepository   db;
    private final CategoryRepository  catDb;

    public ProductService(ProductRepository db, CategoryRepository catDb) { 
        this.db     =   db;
        this.catDb  =   catDb; 
    }


    public List<ProductResponseDTO> getAllProducts(){

        List<Product> products = db.findAll();

        List<ProductResponseDTO> response = products.stream().map(product -> mapToDto(product)).toList();

        return response;
    }

    public ProductResponseDTO getOneProduct(Long id) {

        
        try{
            if(id != null) {
                Product exists = db.findById(id).orElse(null);

                if(exists == null) {
                    return null;
                }

                return mapToDto(exists);
            } else {
                return null;
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductResponseDTO addProduct(ProductCreateDTO prod){
        try{
            Long catId = prod.getCategoryId();
            Category category = catDb.findById(catId).orElse(null);

            if(category == null) {
                return null;
            }

            Product newProduct = new Product(prod.getName(), prod.getDescription(), prod.getPrice() , prod.getStock(), category);

            Product addedProduct = db.save(newProduct);

            return mapToDto(addedProduct);

        } catch(Exception e) {
            e.printStackTrace();
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

    public ProductResponseDTO patchProduct(Long id, ProductUpdateDTO prod){


        try {
            Product found = db.findById(id).orElse(null);

            if(found == null){
                return null;
            }
            

            if (prod.getName() != null) {
                found.setName(prod.getName());
            }

            if (prod.getDescription() != null) {
                found.setDescription(prod.getDescription());
            }

            if (prod.getPrice() != null) {
                found.setPrice(prod.getPrice());
            }

            if (prod.getStock() != null) {
                found.setStock(prod.getStock());
            }

            if (prod.getCategoryId() != null) {
                Category category = catDb.findById(prod.getCategoryId()).orElse(null);

                if (category == null) {
                    return null;
                }

                found.setCategory(category);
            }   

            return mapToDto(db.save(found));

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    private ProductResponseDTO mapToDto(Product prod) {

        if(prod == null) {
            return null;
        }

        Category cat = prod.getCategory();


        Long categoryId = null;
        String categoryName = null;

        if(cat != null) {
            categoryId = cat.getId();
            categoryName = cat.getName();
        }

        return new ProductResponseDTO(prod.getId(), prod.getName(), prod.getDescription(), prod.getPrice(), prod.getStock(), categoryId, categoryName);
    }
}
