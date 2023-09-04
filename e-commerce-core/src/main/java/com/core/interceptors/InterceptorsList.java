package com.core.interceptors;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InterceptorsList {
    private final List<LoadInterceptor<?>> loadInterceptors;
    private final List<PrepareHandleInterceptor<?>> preInterceptors;
    private final List<RemoveInterceptor<?>> removeInterceptors;
    private final List<InitDefaultsInterceptor<?>> initDefaultsInterceptors;
    private final List<ValidateInterceptor<?>> validateInterceptors;

    public InterceptorsList(List<LoadInterceptor<?>> loadInterceptors, List<PrepareHandleInterceptor<?>> preInterceptors, List<RemoveInterceptor<?>> removeInterceptors, List<InitDefaultsInterceptor<?>> initDefaultsInterceptors, List<ValidateInterceptor<?>> validateInterceptors) {
        this.loadInterceptors = loadInterceptors;
        this.preInterceptors = preInterceptors;
        this.removeInterceptors = removeInterceptors;
        this.initDefaultsInterceptors = initDefaultsInterceptors;
        this.validateInterceptors = validateInterceptors;
    }



    public <T> void loadOperation(T model) {
        for (LoadInterceptor<?> interceptor : loadInterceptors) {
            if (interceptor.supports(model.getClass())) {
                interceptor.preHandle(model);
            }
        }
    }
    public <T> void loadOperation(List<T> list) {
        for (LoadInterceptor<?> interceptor : loadInterceptors) {
            if (interceptor.supports(list.get(0).getClass())) {
                for (T model : list) {
                    interceptor.preHandle(model);
                }
            }
        }
    }

    public <T> void prepareOperation(T model) {

        for (PrepareHandleInterceptor<?> interceptor : preInterceptors) {
            if (interceptor.supports(model.getClass())) {
                interceptor.preHandle(model);
            }
        }

    }

    public <T> void removeOperation(T model) {
        for (RemoveInterceptor<?> interceptor : removeInterceptors) {
            if (interceptor.supports(model.getClass())) {
                interceptor.preHandle(model);
            }
        }
    }

    public <T> void initDefaultsOperation(T model) {
        for (InitDefaultsInterceptor<?> interceptor : initDefaultsInterceptors) {
            if (interceptor.supports(model.getClass())) {
                interceptor.preHandle(model);
            }
        }
    }

    public <T> void validateOperation(T model) {
        for (ValidateInterceptor<?> interceptor : validateInterceptors) {
            if (interceptor.supports(model.getClass())) {
                interceptor.onValidate(model);
            }
        }
    }
}
