package com.core.dao.impl;

import com.core.dao.ProductDao;
import com.core.model.Product;
import com.core.service.modelservice.ModelServiceImpl;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {
    private final ModelServiceImpl<Product, String> modelServiceImpl;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public ProductDaoImpl(ModelServiceImpl<Product, String> modelServiceImpl, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.modelServiceImpl = modelServiceImpl;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }


    @Override
    public Product save(Product product) {
        return getModelService().save(product);
    }

    @Override
    public List<Product> findAll() {
        return getModelService().findAll(Product.class);
    }

    @Override
    public Product findById(String id) {
        return getModelService().findById(id, Product.class);
    }

    @Override
    public Product findByCode(String code) {
        return getModelService().findByField("code", code, Product.class);
    }

    @Override
    public List<Product> findAllByCategory(String categoryID) {
        return getModelService().findAllByField("category", categoryID, Product.class);
    }

    @Override
    public Integer countByCategory(String categoryID) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("categoryID", categoryID))
                )
                .build();

        SearchHits<Product> searchHits = getElasticsearchRestTemplate().search(searchQuery, Product.class);
        return Math.toIntExact(searchHits.getTotalHits());
    }

    @Override
    public void remove(String id) {
        getModelService().deleteById(id,Product.class);

    }

    public ModelServiceImpl<Product, String> getModelService() {
        return modelServiceImpl;
    }

    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return elasticsearchRestTemplate;
    }
}
