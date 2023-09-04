package com.facade.dto;


public class ProductResponse {
    private String code;
    private String name;
    private String  brandName;
    private String categoryName;
    private String image;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brandName='" + brandName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
