package com.core.interceptors;

import org.springframework.stereotype.Component;

/** Nesnenin geçerlilik kontrolünü yapar. Gerekli doğrulamaları gerçekleştirerek nesnenin doğru ve tutarlı bir şekilde oluşturulmasını sağlar.*/
@Component
public abstract class ValidateInterceptor<T> {
    public abstract void onValidate(Object entity);
    public abstract boolean supports(Class<?> aClass);
}
