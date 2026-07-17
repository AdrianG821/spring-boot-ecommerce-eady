package com.adrian.eady.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository db;

    public CategoryService(CategoryRepository db) { this.db = db; }


    public List<Category> getAllCategories () {

        try{
            return db.findAll();

        } catch(Exception e) {
            return null;
        }
    }

    public Optional<Category> getCategoryById(Long id) {
        try{
            return db.findById(id);
        } catch(Exception e) {
            return Optional.empty();
        }
    }

    
    public Category addNewCategory(Category cat) {
        try{
            return db.save(cat);

        } catch(Exception e) {
            return null;
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
    
    public Category updateCategoryById(Long id, Category cat) {
        try{
            Category found = db.findById(id).orElse(null);

            if(found == null) {
                return null;
            }

            found.setName(cat.getName());
            found.setActive(cat.getActive());

            return db.save(found);
            

        } catch(Exception e) {
            return null;
        }
    }
}
