package com.facade.facade;


import com.core.model.Brand;
import com.core.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandFacade {
    private final BrandService brandService;


    public BrandFacade(BrandService brandService) {
        this.brandService = brandService;
    }

    public void save(Brand brand) {
        getBrandService().save(brand);
    }

    public List<Brand> findAll() {
        return getBrandService().findAll();
    }

    public Brand findById(String id) {
        return getBrandService().findById(id);
    }

    public List<Brand> findAllByCategory(String categoryID) {
        return getBrandService().findAllByCategory(categoryID);
    }

    public Integer countByCategory(String categoryID) {
        return getBrandService().countByCategory(categoryID);
    }

    public BrandService getBrandService() {
        return brandService;
    }
}
