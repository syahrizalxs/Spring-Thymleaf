package com.belajar.spring.dao;

import com.belajar.spring.entity.Student;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */
public interface StudentDAO extends BaseDAO<Student> {
    List<Student> findByName(Student param);
}
