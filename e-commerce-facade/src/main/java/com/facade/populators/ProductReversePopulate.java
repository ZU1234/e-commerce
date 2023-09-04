package com.facade.populators;

import com.core.model.Product;
import com.core.service.impl.BrandServiceImpl;
import com.core.service.impl.CategoryServiceImpl;
import com.facade.dto.ProductRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductReversePopulate implements Converter<ProductRequest, Product> {
    private final CategoryServiceImpl categoryServiceImpl;
    private final BrandServiceImpl brandServiceImpl;

    public ProductReversePopulate(CategoryServiceImpl categoryServiceImpl, BrandServiceImpl brandServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
        this.brandServiceImpl = brandServiceImpl;
    }

    @Override
    public Product convert(ProductRequest source) {
//        Brand brand = brandServiceImpl.findById(source.getBrandId()).orElseThrow();
//        SubCategory subCategory = categoryServiceImpl.findBySubCategoryId(source.getSubCategoryId()).orElseThrow();

        Product target = new Product();
//        target.setSubcategoryId(subCategory.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
//        target.setBrandId(brand.getId());
        target.setImage(source.getImage());
        return target;
    }
}
