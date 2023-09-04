package com.core.interceptors;

import org.springframework.stereotype.Component;

/**
 * Create (oluşturma) işlemi öncesinde tetiklenir.Yeni bir veri oluşturma işlemi öncesinde varsayılan değerler ayarlanabilir veya özel işlemler gerçekleştirilebilir.
 */
@Component
public abstract class InitDefaultsInterceptor<T> {
    /*InitDefaultsInterceptor'u kullanarak bir nesne oluşturulduğunda veya kaydedildiğinde varsayılan değerlerin atanmasını sağlayabilirsiniz. Bu, tekrarlayan işlemleri azaltır, kod tekrarını önler ve nesnenin başlangıç durumunu belirlemenize yardımcı olur.*/
    public abstract void preHandle(Object entity);
    public abstract boolean supports(Class<?> aClass);
}
