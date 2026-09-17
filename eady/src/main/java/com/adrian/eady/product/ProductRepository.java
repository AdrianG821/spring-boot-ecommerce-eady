package com.adrian.eady.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProducts(List<Long> id);
}
