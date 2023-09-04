package com.core.model;


import com.core.model.abstracts.BaseModel;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "brands")
public class Brand extends BaseModel {

}
