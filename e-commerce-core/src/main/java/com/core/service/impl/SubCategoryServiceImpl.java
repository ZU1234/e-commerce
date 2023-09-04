package com.core.service.impl;

import com.core.dao.SubCategoryDao;
import com.core.model.product.category.SubCategory;
import com.core.service.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private SubCategoryDao subCategoryDao;

    public SubCategoryServiceImpl(SubCategoryDao subCategoryDao) {
        this.subCategoryDao = subCategoryDao;
    }

    @Override
    public SubCategory save(SubCategory subCategory) {
        return getSubCategoryDao().save(subCategory);
    }

    @Override
    public List<SubCategory> findAll() {
        return getSubCategoryDao().findAll();
    }

    @Override
    public List<String> findAllName() {
        return getSubCategoryDao().findAllName();
    }

    @Override
    public SubCategory findById(String id) {
        return getSubCategoryDao().findById(id);
    }

    @Override
    public List<SubCategory> findAllByCategory(String subCategoryID) {
        return getSubCategoryDao().findAllByCategory(subCategoryID);
    }

    @Override
    public Integer countBySubCategory(String subCategoryID) {
        return getSubCategoryDao().countBySubCategory(subCategoryID);
    }

    @Override
    public void remove(String id) {
        getSubCategoryDao().remove(id);
    }

    public SubCategoryDao getSubCategoryDao() {
        return subCategoryDao;
    }
}
