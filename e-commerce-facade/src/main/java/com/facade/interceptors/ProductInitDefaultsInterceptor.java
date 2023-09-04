package com.facade.interceptors;

import com.core.model.enums.State;
import com.core.model.Product;
import com.core.interceptors.InitDefaultsInterceptor;
import org.springframework.stereotype.Component;

@Component
public class ProductInitDefaultsInterceptor extends InitDefaultsInterceptor<Product> {
    @Override
    public void preHandle(Object entity) {
        if (entity instanceof Product) {
            ((Product) entity).setAvgPoint(0);
            ((Product) entity).setState(State.DEFAULT.toString());
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Product.class);
    }
}
