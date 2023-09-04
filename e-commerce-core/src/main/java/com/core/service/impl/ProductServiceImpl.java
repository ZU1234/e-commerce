package com.core.service.impl;

import com.core.dao.ProductDao;
import com.core.model.Product;
import com.core.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product save(Product product) {
        return getProductDao().save(product);
    }

    @Override
    public List<Product> findAll() {
        return getProductDao().findAll();
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAllByCategory(String categoryID) {
        return productDao.findAllByCategory(categoryID);
    }

    @Override
    public Integer countByCategory(String categoryID) {
        return productDao.countByCategory(categoryID);
    }

    @Override
    public void remove(String id) {
getProductDao().remove(id);
    }

    @Override
    public Product findByCode(String code) {
        return getProductDao().findByCode(code);
    }

    public ProductDao getProductDao() {
        return productDao;
    }
}
