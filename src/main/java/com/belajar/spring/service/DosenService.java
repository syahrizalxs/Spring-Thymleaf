/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.service;

import com.belajar.spring.entity.Dosen;

import java.util.List;

/**
 *
 * @author Desi Widyawati
 */
public interface DosenService extends BaseService<Dosen>{
    List<Dosen> findByName (Dosen param);
}
