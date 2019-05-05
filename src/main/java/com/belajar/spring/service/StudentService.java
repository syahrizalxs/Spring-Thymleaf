package com.belajar.spring.service;


import com.belajar.spring.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    List<Student> findByName(Student param);
}
