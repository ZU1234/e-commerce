package com.core.dao;

import com.core.model.Product;

import java.util.List;

public interface ProductDao {

    Product save(Product product);

    List<Product> findAll();

    Product findById(String id);

    Product findByCode(String code);

    List<Product> findAllByCategory(String categoryID);

    Integer countByCategory(String categoryID);

    void remove(String id);
}


