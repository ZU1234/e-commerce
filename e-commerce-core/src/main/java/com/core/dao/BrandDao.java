package com.core.dao;

import com.core.model.Brand;

import java.util.List;

public interface BrandDao {
    Brand save(Brand brand);

    List<Brand> findAll();

    Brand findById(String id);

    List<Brand> findAllByCategory(String categoryID);

    Integer countByCategory(String categoryID);

    void remove(String id);
}
