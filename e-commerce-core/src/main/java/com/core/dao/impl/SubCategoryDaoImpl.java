package com.core.dao.impl;

import com.core.dao.SubCategoryDao;
import com.core.model.product.category.SubCategory;
import com.core.service.modelservice.ModelService;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SubCategoryDaoImpl implements SubCategoryDao {
    private ModelService<SubCategory,String> modelService;
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public SubCategoryDaoImpl(ModelService<SubCategory, String> modelService, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.modelService = modelService;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @Override
    public SubCategory save(SubCategory subCategory) {
        return getModelService().save(subCategory);
    }

    @Override
    public List<SubCategory> findAll() {
        return getModelService().findAll(SubCategory.class);
    }

    @Override
    public List<String> findAllName() {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFields("name") // Sadece "name" alanını döndürecek şekilde sorgu oluştur
                .build();

        // Elasticsearch sorgusunu çalıştırma
        SearchHits<String> searchHits = elasticsearchRestTemplate.search(searchQuery,String.class);

        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategory findById(String id) {
        return getModelService().findById(id,SubCategory.class);
    }

    @Override
    public List<SubCategory> findAllByCategory(String subCategoryID) {
        return null;
    }

    @Override
    public Integer countBySubCategory(String subCategoryID) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    public ModelService<SubCategory, String> getModelService() {
        return modelService;
    }
}
