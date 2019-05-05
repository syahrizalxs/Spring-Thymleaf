package com.belajar.spring.service;

import com.belajar.spring.entity.Student;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */
public interface BaseService<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    List<T> find();

    T findById(int id);


}
