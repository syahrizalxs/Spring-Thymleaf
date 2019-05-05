package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.Student;
import javafx.scene.control.Tab;
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
        String sql = "INSERT INTO " + Table.TABLE_STUDENT + " (name , address, jurusan_id) VALUES (?,?,?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            ps.setString(3, param.getJurusan_id());
            return ps;
        }, keyHolder);

        param.setStudent_id(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

//    @Override
//    public Student update(Student param) {
//        String sql = "UPDATE " + Table.TABLE_STUDENT + " SET " +
//                "name = ?, " +
//                "address = ? " +
//                "WHERE student_id =  ? ";
//
//        jdbcTemplate.update(sql,
//                param.getName(),
//                param.getAddress(),
//                param.getStudent_id());
//
//        return param;
//    }

    @Override
    public Student update(Student param) {
        String sql = "update " + Table.TABLE_STUDENT + " set name=?,address=? where student_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            ps.setInt(3, param.getStudent_id());
            return ps;
        });
        param.setStudent_id(rtn);
        return param;
    }

    @Override
    public int delete(Student param) {
        String sql = "DELETE from " + Table.TABLE_STUDENT + " where student_id = ?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getStudent_id());
            return ps;
        });
        return rtn;
    }

    @Override
    public List<Student> find() {
        String sql = "SELECT * FROM " + Table.TABLE_STUDENT;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM "+ Table.TABLE_STUDENT + " where student_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

    @Override
    public List<Student> findByName(Student param){
        String sql = "select * from " + Table.TABLE_STUDENT + " where name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getName() + "%"}, new BeanPropertyRowMapper<>(Student.class));
    }
}
