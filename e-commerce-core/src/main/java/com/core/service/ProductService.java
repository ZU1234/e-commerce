package com.core.service;

import com.core.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(String id);
    List<Product> findAllByCategory(String categoryID);
    Integer countByCategory(String categoryID);
    void remove(String id);
    Product findByCode(String code);
}
