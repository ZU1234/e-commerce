package com.core.service;

import com.core.model.product.category.SubCategory;

import java.util.List;

public interface SubCategoryService {
    SubCategory save(SubCategory subCategory);

    List<SubCategory> findAll();

    List<String> findAllName();

    SubCategory findById(String id);

    List<SubCategory> findAllByCategory(String subCategoryID);

    Integer countBySubCategory(String subCategoryID);

    void remove(String id);
}
