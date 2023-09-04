package com.core.service;

import com.core.model.Brand;

import java.util.List;

public interface BrandService {
    Brand save(Brand brand);

    List<Brand> findAll();

    Brand findById(String id);

    List<Brand> findAllByCategory(String categoryID);

    Integer countByCategory(String categoryID);

    void remove(String id);
}
