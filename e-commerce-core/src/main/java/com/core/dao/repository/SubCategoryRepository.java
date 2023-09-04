package com.core.dao.repository;

import com.core.model.product.category.SubCategory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SubCategoryRepository extends ElasticsearchRepository<SubCategory,String> {
}
