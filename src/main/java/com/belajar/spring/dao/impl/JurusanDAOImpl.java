/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.JurusanDAO;
import com.belajar.spring.entity.Jurusan;
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
public class JurusanDAOImpl implements JurusanDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Jurusan save(Jurusan param) {
        String sql = "INSERT INTO " + Table.TABLE_JURUSAN + " (jurusan_id, namaJurusan, fakultas) VALUES (?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getJurusan_id());
            ps.setString(2, param.getNamaJurusan());
            ps.setString(3, param.getFakultas());
            return ps;
        }, keyHolder);

        param.setJurusan_id (param.getJurusan_id());
        return param;
    }

    @Override
    public Jurusan update(Jurusan param) {
        String sql = "UPDATE " + Table.TABLE_JURUSAN + " SET " +
                "namaJurusan = ?, " +
                "fakultas = ? " +
                "WHERE jurusan_id =  ? ";

        jdbcTemplate.update(sql,
                param.getNamaJurusan(),
                param.getFakultas(),
                param.getJurusan_id());

        return param;
    }

    @Override
    public int delete(Jurusan param) {
        String sql = "DELETE FROM " + Table.TABLE_JURUSAN + " WHERE jurusan_id = ? ";

        return jdbcTemplate.update(sql, param.getJurusan_id());
    }

    @Override
    public List<Jurusan> find() {
        String sql = "SELECT * FROM " + Table.TABLE_JURUSAN;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Jurusan.class));
    }

    @Override
    public Jurusan findById(int jurusan_id) {
        String sql = "SELECT * FROM " + Table.TABLE_JURUSAN + " WHERE jurusan_id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Jurusan.class), jurusan_id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
}
