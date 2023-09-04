package com.core.model.product.category;

import com.core.model.abstracts.BaseModel;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "subcategories")
public class SubCategory extends BaseModel {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
