package com.adrian.eady.categories;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean active;

    public Category() {}

    public Category(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean getActive(){
        return active;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setActive(boolean newActive) {
        active = newActive;
    }


    
    
}
