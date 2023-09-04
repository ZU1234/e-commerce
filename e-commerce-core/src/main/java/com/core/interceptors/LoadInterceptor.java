package com.core.interceptors;

import org.springframework.stereotype.Component;

/**
 * Nesnenin yükleme aşamasını takip eder. Örneğin, nesneyi bir veri kaynağından yükleyebilir veya gerektiğinde önbelleğe alabilir.
 */
/*Bir LoadInterceptor'un kullanımı, bir nesne veritabanından getirildiğinde özel işlemler gerçekleştirmek için uygundur.*/
@Component
public abstract class LoadInterceptor<T> {

    public abstract void preHandle(Object entity);

    public abstract boolean supports(Class<?> aClass);
}

/*LoadInterceptor'ların void dönüş tipine sahip olmasının nedeni, yükleme işlemi sırasında gerçekleştirilen özel işlemlerin nesnenin kendisi üzerinde doğrudan değişiklik yapmasıdır. Bu nedenle, LoadInterceptor, nesnenin değiştirilmiş halini doğrudan etkiler ve dönüş değeri olarak bir şey döndürmesine gerek duyulmaz.

LoadInterceptor'lar, genellikle yükleme işlemi sırasında yapılandırma, veri dönüşümü, veri doğrulama, ilişkili verilerin yüklenmesi gibi işlemleri gerçekleştirmek için kullanılır. Bu işlemler, nesnenin kendisi üzerinde doğrudan etki eder ve değişikliklerin nesneye yansıması yeterlidir. Bu nedenle, LoadInterceptor'lar genellikle void dönüş tipine sahiptir.*/
