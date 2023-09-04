package com.core.interceptors;

import org.springframework.stereotype.Component;

/**
 * Nesnenin silme aşamasından sonra belirli işlemleri gerçekleştirir. Örneğin, silme işleminden sonra ilişkili kaynakları temizleme veya geri dönüşüm işlemleri yapabilir.
 */
@Component
public abstract class RemoveInterceptor<T> {
    public abstract void preHandle(Object entity);

    public abstract boolean supports(Class<?> aClass);
}
