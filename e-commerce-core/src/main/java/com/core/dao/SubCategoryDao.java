package com.core.dao;

import com.core.model.product.category.SubCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubCategoryDao {
    SubCategory save(SubCategory subCategory);

    List<SubCategory> findAll();

    List<String> findAllName();

    SubCategory findById(String id);

    List<SubCategory> findAllByCategory(String subCategoryID);

    Integer countBySubCategory(String subCategoryID);

    void remove(String id);
}
