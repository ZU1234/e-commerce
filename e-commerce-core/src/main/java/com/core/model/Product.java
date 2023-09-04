package com.core.model;

import com.core.model.abstracts.BaseModel;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "products")
public class Product extends BaseModel {
    private String code;
    private String subcategoryId;
    private String brandId;
    private String image;
    private int avgPoint;
    private String state;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(int avgPoint) {
        this.avgPoint = avgPoint;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
