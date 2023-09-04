package com.core.dao.repository;

import com.core.model.product.category.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category, String> {
}
