package com.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "comments")
public class Comment {
    @Id
    private long id;
    private Product productCode;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProductCode() {
        return productCode;
    }

    public void setProductCode(Product productCode) {
        this.productCode = productCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String description) {
        this.comment = description;
    }
}
