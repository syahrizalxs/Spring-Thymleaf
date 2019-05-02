package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.KRSDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.KRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */

@Repository
public class KRSDAOImpl implements KRSDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

  

 

    @Override
    public int delete(KRS param) {
        String sql = "DELETE FROM " + Table.TABLE_KRS + " WHERE KRS_id = ? ";

        return jdbcTemplate.update(sql, param.getNoKRS());
    }

    @Override
    public List<KRS> find() {
        String sql = "SELECT tk.noKRS,s.student_id,s.NAME, mk.namaMataKuliah,mk.jumlahSks,tk.semester "
                + "from (" + Table.TABLE_STUDENT +" s left JOIN "+ Table.TABLE_KRS+" tk on s.student_id = "
                + "tk.student_id ) LEFT JOIN "+ Table.TABLE_MATKUL +" mk ON tk.id_matkul = mk.id_matkul";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(KRS.class));
    }

    @Override
    public KRS findById(int id) {
        String sql = "SELECT tk.noKRS,s.student_id,s.NAME, mk.namaMataKuliah,mk.jumlahSks,tk.semester "
                + "from (" + Table.TABLE_STUDENT +" s left JOIN "+ Table.TABLE_KRS+" tk on s.student_id = "
                + "tk.student_id ) LEFT JOIN "+ Table.TABLE_MATKUL +" mk ON tk.id_matkul = mk.id_matkul "
                + "WHERE s.student_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(KRS.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

    @Override
    public List<KRS> findByStudentId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KRS save(KRS param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KRS update(KRS param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 

}
