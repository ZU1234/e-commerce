package com.core.dao;

import com.core.model.product.category.Category;

import java.util.List;

public interface CategoryDao {
    Category save(Category category);

    List<Category> findAll();

    Category findById(String id);

    void remove(String id);
}
