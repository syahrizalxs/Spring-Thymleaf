/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.service.impl;

import com.belajar.spring.dao.DosenDAO;
import com.belajar.spring.entity.Dosen;
import com.belajar.spring.service.DosenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desi Widyawati
 */
@Service
public class DosenServiceImpl implements DosenService {
     @Autowired
    private DosenDAO dosenDAO;


    @Override
    public Dosen save(Dosen param) {
        return dosenDAO.save(param);
    }

    @Override
    public Dosen update(Dosen param) {
        return dosenDAO.update(param);
    }

    @Override
    public int delete(Dosen param) {
        return dosenDAO.delete(param);
    }

    @Override
    public List<Dosen> find() {
        List<Dosen> dosen = dosenDAO.find();
        for (Dosen data : dosen){
            data.setDosen_id(data.getDosen_id());
        }

        return dosen;
    }

    @Override
    public Dosen findById(int id) {
        return dosenDAO.findById(id);
    }

    @Override
    public List<Dosen> findByName(Dosen param){
        return dosenDAO.findByName(param);
    }
}
