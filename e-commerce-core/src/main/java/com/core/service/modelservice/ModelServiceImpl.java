package com.core.service.modelservice;
import com.core.interceptors.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ModelServiceImpl<T,V> extends InterceptorsList implements ModelService<T,V> {
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public ModelServiceImpl(List<LoadInterceptor<?>> loadInterceptors, List<PrepareHandleInterceptor<?>> preInterceptors, List<RemoveInterceptor<?>> removeInterceptors, List<InitDefaultsInterceptor<?>> initDefaultsInterceptors, List<ValidateInterceptor<?>> validateInterceptors, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        super(loadInterceptors, preInterceptors, removeInterceptors, initDefaultsInterceptors, validateInterceptors);
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }


    @Override
    public T save(T model) {
        prepareOperation(model);
        validateOperation(model);

        T savedModel = getElasticsearchRestTemplate().save(model);

        loadOperation(savedModel);
        return savedModel;
    }
    @Override
    public List<T> findAll(Class<T> clazz) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .build();


        SearchHits<T> searchHits = elasticsearchRestTemplate.search(searchQuery, clazz);
        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }
    @Override
    public T findById(String id,Class<T> clazz) {
        return elasticsearchRestTemplate.get(id, clazz);
    }

    @Override
    public void deleteById(String id, Class<T> clazz) {
        elasticsearchRestTemplate.delete(id, clazz);
    }

    @Override
    public T findByField(String fieldName, V value, Class<T> clazz) {
        return Optional.ofNullable(elasticsearchRestTemplate.get(fieldName + ":" + value, clazz)).orElseThrow();
    }

    @Override
    public List<T> findAllByField(String fieldName, V value, Class<T> clazz) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                // Belirli alanı ve değeri eşleştiren bir sorgu oluştur

                .withQuery(QueryBuilders.matchQuery(fieldName, value))
                .build();
        // Elasticsearch sorgusunu çalıştırma
        SearchHits<T> searchHits = elasticsearchRestTemplate.search(searchQuery, clazz);
        // Çıkan sonuçları bir liste olarak toplama

        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }


    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return elasticsearchRestTemplate;
    }
}
