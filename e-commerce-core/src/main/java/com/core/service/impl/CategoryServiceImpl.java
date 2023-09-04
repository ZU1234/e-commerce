package com.core.service.impl;

import com.core.dao.CategoryDao;
import com.core.model.product.category.Category;
import com.core.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category save(Category category) {
        return getCategoryDao().save(category);
    }

    @Override
    public List<Category> findAll() {
        return getCategoryDao().findAll();
    }

    @Override
    public Category findById(String id) {
        return getCategoryDao().findById(id);
    }

    @Override
    public void remove(String id) {
        getCategoryDao().remove(id);

    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
}
