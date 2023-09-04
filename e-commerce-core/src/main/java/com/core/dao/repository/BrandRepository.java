package com.core.dao.repository;

import com.core.model.Brand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BrandRepository extends ElasticsearchRepository<Brand, Long> {
}
