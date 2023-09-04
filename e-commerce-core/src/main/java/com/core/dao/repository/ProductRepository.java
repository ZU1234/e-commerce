package com.core.dao.repository;

import com.core.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository  extends ElasticsearchRepository<Product, Long> {
//    @Query(value = ProductQuery.FIND_BY_CODE, nativeQuery = true)
//    Product findByCode(String code);
//
//    @Query(value = ProductQuery.FIND_ALL_BY_CATEGORY_ID, nativeQuery = true)
//    List<Product> findAllByCategory(long categoryID);
//
//    @Query(value = ProductQuery.GET_COUNT_FOR_CATEGORY, nativeQuery = true)
//    Integer countFindByCategory(long categoryID);
}
