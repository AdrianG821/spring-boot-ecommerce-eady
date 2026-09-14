package com.adrian.eady.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.eady.categories.dto.CategoryResponseDTO;

@Service
public class CategoryService {

    private final CategoryRepository db;

    public CategoryService(CategoryRepository db) { this.db = db; }


    public List<CategoryResponseDTO> getAllCategories () {

        try{
            List<Category> categories = db.findAll();

            List<CategoryResponseDTO> response = categories.stream().map( cat -> new CategoryResponseDTO(cat.getId(), cat.getName()) ).toList();

            return response;

        } catch(Exception e) {
            return null;
        }
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        try{
            Category category = db.findById(id).orElse(null);

            if(category == null) return null;
            
            CategoryResponseDTO response = new CategoryResponseDTO(category.getId(), category.getName());

            return response;

        } catch(Exception e) {
            return null;
        }
    }

    
    public String addNewCategory(String name) {
        try{
            Category cat = new Category(name, true);
            
            db.save(cat);

            return "Category created!";

        } catch(Exception e) {
            return "Something went wrong!";
        }

    }

    
    public String deleteCategoryById(Long id) {
        try{

            Category exists = db.findById(id).orElse(null);

            if(exists == null) {
                return "Category not found";
            }


            db.deleteById(id);
            return "Category deleted";

        } catch(Exception e) {
            return "Category not deleted";
        }
    }
    
    public String updateCategoryById(Long id) {
        try{
            Category found = db.findById(id).orElse(null);

            if(found == null) {
                return null;
            }

            if(found.getActive() == true){
                found.setActive(false);
            } else {
                found.setActive(true);
            }

            db.save(found);
           
            return "Category updated!";

        } catch(Exception e) {
            return "Something went wrong!";
        }
    }
}
