package com.core.dao.impl;

import com.core.dao.CategoryDao;
import com.core.model.product.category.Category;
import com.core.service.modelservice.ModelService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {
    private ModelService<Category, String> modelService;

    public CategoryDaoImpl(ModelService<Category, String> modelService) {
        this.modelService = modelService;
    }

    @Override
    public Category save(Category category) {
        return getModelService().save(category);
    }

    @Override
    public List<Category> findAll() {
        return getModelService().findAll(Category.class);
    }

    @Override
    public Category findById(String id) {
        return getModelService().findById(id, Category.class);
    }

    @Override
    public void remove(String id) {
        getModelService().deleteById(id, Category.class);
    }

    public ModelService<Category, String> getModelService() {
        return modelService;
    }
}
