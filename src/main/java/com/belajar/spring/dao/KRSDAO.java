package com.belajar.spring.dao;

import com.belajar.spring.entity.KRS;

import java.util.List;

public interface KRSDAO extends BaseDAO<KRS> {

    List<KRS> findByStudentId(int id);

}
