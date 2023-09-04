package com.facade.facade;

import com.core.model.product.category.Category;
import com.core.service.CategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade {
    private final CategoryService categoryService;

    public CategoryFacade(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category findById(String id) {
        return getCategoryService().findById(id);
    }

    public List<Category> findAll() {
        return getCategoryService().findAll();
    }
    public void save(Category category){
     getCategoryService().save(category);
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }
}
