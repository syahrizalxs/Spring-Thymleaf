package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student save(Student param) {
        String sql = "INSERT INTO " + Table.TABLE_STUDENT + " (name, address) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            return ps;
        }, keyHolder);

        param.setStudent_id(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Student update(Student param) {
        String sql = "UPDATE " + Table.TABLE_STUDENT + " SET " +
                "name = ?, " +
                "address = ? " +
                "WHERE student_id =  ? ";

        jdbcTemplate.update(sql,
                param.getName(),
                param.getAddress(),
                param.getStudent_id());

        return param;
    }

    @Override
    public int delete(Student param) {
        String sql = "DELETE FROM " + Table.TABLE_STUDENT + " WHERE student_id = ? ";

        return jdbcTemplate.update(sql, param.getStudent_id());
    }

    @Override
    public List<Student> find() {
        String sql = "SELECT * FROM " + Table.TABLE_STUDENT;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT student_id, name, address, namaJurusan,fakultas " +
                " FROM " + Table.TABLE_STUDENT +" INNER JOIN " +Table.TABLE_JURUSAN +
                " ON " + Table.TABLE_STUDENT + ".jurusan_id = " + Table.TABLE_JURUSAN + ".jurusan_id"
                +" WHERE " + Table.TABLE_STUDENT + ".student_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
    
 

}
