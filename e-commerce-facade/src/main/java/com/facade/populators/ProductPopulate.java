package com.facade.populators;

import com.core.model.Product;
import com.facade.dto.ProductResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductPopulate implements Converter<Product, ProductResponse> {
    @Override
    public ProductResponse convert(Product source) {
        ProductResponse target = new ProductResponse();
//        target.setCategoryName(source.getSubcategory().getName());
        target.setCode(source.getCode());
        target.setName(source.getName());
//        target.setBrandName(source.getBrand().getName());
        target.setImage(source.getImage());
        return target;
    }

}
