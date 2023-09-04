package com.facade.facade;

import com.core.model.Product;
import com.core.service.impl.ProductServiceImpl;
import com.facade.dto.ProductRequest;
import com.facade.dto.ProductResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {
    private final ProductServiceImpl productServiceImpl;
    private final Converter<Product, ProductResponse> productConverter;
    private final Converter<ProductRequest, Product> productReverseConverter;

    public ProductFacade(ProductServiceImpl productServiceImpl, Converter<Product, ProductResponse> productConverter, Converter<ProductRequest, Product> productReverseConverter) {
        this.productServiceImpl = productServiceImpl;
        this.productConverter = productConverter;
        this.productReverseConverter = productReverseConverter;
    }

    public void save(ProductRequest productRequest) {
        Product product = getProductReverseConverter().convert(productRequest);
        getProductService().save(product);
    }

    public List<ProductResponse> findAll() {
        return getProductService().findAll().stream()
                .map(getProductConverter()::convert)
                .collect(Collectors.toList());
    }

    public ProductResponse findByCode(String code) {
        return getProductConverter().convert(getProductService().findByCode(code));
    }

    private ProductResponse findById(String id) {
        Product product = getProductService().findById(id);

        return getProductConverter().convert(product);
    }

    public List<ProductResponse> findAllByCategory(String categoryId) {
        return getProductService().findAllByCategory(categoryId).stream()
                .map(getProductConverter()::convert).collect(Collectors.toList());
    }

    public Integer findProductsCountByCategory(String categoryId) {
        return getProductService().countByCategory(categoryId);
    }
    public void remove(String id){
        getProductService().remove(id);
    }

    public ProductServiceImpl getProductService() {
        return productServiceImpl;
    }

    public Converter<Product, ProductResponse> getProductConverter() {
        return productConverter;
    }

    public Converter<ProductRequest, Product> getProductReverseConverter() {
        return productReverseConverter;
    }
}
