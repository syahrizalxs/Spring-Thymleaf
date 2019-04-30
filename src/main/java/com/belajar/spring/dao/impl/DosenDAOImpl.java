/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.DosenDAO;
import com.belajar.spring.entity.Dosen;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desi Widyawati
 */
@Repository
public class DosenDAOImpl implements DosenDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Dosen save(Dosen param) {
        String sql = "INSERT INTO " + Table.TABLE_DOSEN + " (name, address) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            return ps;
        }, keyHolder);

        param.setDosen_id(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Dosen update(Dosen param) {
        String sql = "UPDATE " + Table.TABLE_DOSEN + " SET " +
                "name = ?, " +
                "address = ? " +
                "WHERE dosen_id =  ? ";

        jdbcTemplate.update(sql,
                param.getName(),
                param.getAddress(),
                param.getDosen_id());

        return param;
    }

    @Override
    public int delete(Dosen param) {
        String sql = "DELETE FROM " + Table.TABLE_DOSEN + " WHERE dosen_id = ? ";

        return jdbcTemplate.update(sql, param.getDosen_id());
    }

    @Override
    public List<Dosen> find() {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dosen.class));
    }

    @Override
    public Dosen findById(int dosen_id) {
        String sql = "SELECT * FROM " + Table.TABLE_DOSEN + " WHERE dosen_id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dosen.class), dosen_id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
}
