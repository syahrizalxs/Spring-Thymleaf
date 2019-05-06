/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.dao;

import com.belajar.spring.entity.Dosen;
import sun.invoke.util.BytecodeName;

import java.util.List;

/**
 *
 * @author Desi Widyawati
 */
public interface DosenDAO extends BaseDAO<Dosen> {
    List<Dosen> findByName (Dosen param);
}
