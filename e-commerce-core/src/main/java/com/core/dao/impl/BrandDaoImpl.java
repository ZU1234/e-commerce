package com.core.dao.impl;

import com.core.dao.BrandDao;
import com.core.model.Brand;
import com.core.service.modelservice.ModelService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandDaoImpl implements BrandDao {
    private ModelService<Brand, String> modelService;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public BrandDaoImpl(ModelService<Brand, String> modelService, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.modelService = modelService;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @Override
    public Brand save(Brand brand) {
        return getModelService().save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return getModelService().findAll(Brand.class);
    }

    @Override
    public Brand findById(String id) {
        return getModelService().findById(id,Brand.class);
    }

    @Override
    public List<Brand> findAllByCategory(String categoryID) {
        return getModelService().findAllByField("categoryID",categoryID,Brand.class);
    }

    @Override
    public Integer countByCategory(String categoryID) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("categoryID", categoryID))
                )
                .build();

        SearchHits<Brand> searchHits = getElasticsearchRestTemplate().search(searchQuery,Brand.class);
        return Math.toIntExact(searchHits.getTotalHits());
    }

    @Override
    public void remove(String id) {
        getModelService().deleteById(id,Brand.class);
    }

    public ModelService<Brand, String> getModelService() {
        return modelService;
    }

    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return elasticsearchRestTemplate;
    }
}
