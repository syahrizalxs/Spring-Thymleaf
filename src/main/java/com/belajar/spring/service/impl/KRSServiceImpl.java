/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.service.impl;

import com.belajar.spring.dao.KRSDAO;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.service.KRSService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desi Widyawati
 */
@Service
public class KRSServiceImpl implements KRSService {
    @Autowired
    private KRSDAO krsDAO;

    @Override
    public KRS save(KRS param) {
        return krsDAO.save(param);
    }

    @Override
    public KRS update(KRS param) {
        return krsDAO.update(param);
    }

    @Override
    public int delete(KRS param) {
        return krsDAO.delete(param);
    }

    @Override
    public List<KRS> find() {
        List<KRS> krs = krsDAO.find();
        for (KRS data : krs){
            data.setNoKRS(data.getNoKRS());
        }
        return krs;
      
    }

    @Override
    public KRS findById(int id) {
         return krsDAO.findById(id);
    }
    
}
