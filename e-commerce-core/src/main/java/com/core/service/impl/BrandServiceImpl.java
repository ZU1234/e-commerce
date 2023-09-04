package com.core.service.impl;

import com.core.dao.BrandDao;
import com.core.model.Brand;
import com.core.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandDao brandDao;

    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public Brand save(Brand brand) {
        return (Brand) getBrandDao().save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return getBrandDao().findAll();
    }

    public Brand findById(String id) {
        return getBrandDao().findById(id);
    }

    @Override
    public List<Brand> findAllByCategory(String categoryID) {
        return null;
    }

    @Override
    public Integer countByCategory(String categoryID) {
        return getBrandDao().countByCategory(categoryID);
    }

    @Override
    public void remove(String id) {
        getBrandDao().remove(id);
    }

    public BrandDao getBrandDao() {
        return brandDao;
    }
}
