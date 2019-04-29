package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.KRSDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KRSDAOImpl implements KRSDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public KRS save(KRS param) {
        return null;
    }

    @Override
    public KRS update(KRS param) {
        return null;
    }

    @Override
    public int delete(KRS param) {
        return 0;
    }

    @Override
    public List<KRS> find() {
        return null;
    }

    @Override
    public KRS findById(int id) {
        return null;
    }

    @Override
    public List<KRS> findByStudentId(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_KRS + " WHERE student_id = " + id;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(KRS.class));
    }
}
