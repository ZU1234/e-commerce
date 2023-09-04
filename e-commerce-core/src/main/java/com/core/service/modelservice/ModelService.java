package com.core.service.modelservice;

import java.util.List;

public interface ModelService<T,V> {
    T save(T model);

    T findById(String id,Class<T> clazz);

    List<T> findAll(Class<T> clazz);

    void deleteById(String id, Class<T> clazz);


    T findByField(String fieldName, V value, Class<T> clazz);

    List<T> findAllByField(String fieldName, V value, Class<T> clazz);
}
