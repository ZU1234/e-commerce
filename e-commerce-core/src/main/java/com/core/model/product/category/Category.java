package com.core.model.product.category;


import com.core.model.abstracts.BaseModel;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "categories")
public class Category extends BaseModel {

}
