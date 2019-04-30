/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.service.impl;

import com.belajar.spring.dao.JurusanDAO;
import com.belajar.spring.entity.Jurusan;
import com.belajar.spring.service.JurusanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desi Widyawati
 */

@Service
public class JurusanServiceImpl implements JurusanService {
    
    @Autowired
    private JurusanDAO jurusanDAO;


    @Override
    public Jurusan save(Jurusan param) {
        return jurusanDAO.save(param);
    }

    @Override
    public Jurusan update(Jurusan param) {
        return jurusanDAO.update(param);
    }

    @Override
    public int delete(Jurusan param) {
        return jurusanDAO.delete(param);
    }

    @Override
    public List<Jurusan> find() {
        List<Jurusan> jurusan = jurusanDAO.find();
        for (Jurusan data : jurusan){
            data.setJurusan_id(data.getJurusan_id());
        }
        return jurusan;
    }

    @Override
    public Jurusan findById(int id) {
        return jurusanDAO.findById(id);
    }
}
