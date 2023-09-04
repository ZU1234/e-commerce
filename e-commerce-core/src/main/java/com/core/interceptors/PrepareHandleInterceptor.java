package com.core.interceptors;

import org.springframework.stereotype.Component;

/**
 * entity üzerinde bazı kontroller yapabilir veya validasyon işlemleri uygulayabilirsiniz.İşlem öncesinde ek kontroller veya işlemler gerçekleştirilebilir.
 */
@Component
public abstract class PrepareHandleInterceptor<T> {

    public abstract void  preHandle(Object entity);

    public abstract boolean supports(Class<?> aClass);
}
