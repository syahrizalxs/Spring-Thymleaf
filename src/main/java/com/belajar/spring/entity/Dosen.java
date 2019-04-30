/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Desi Wdosen_idyawati
 */

@Getter
@Setter
public class Dosen implements Serializable {
    private int dosen_id;

    private String name;

    private String address;

    public Dosen() {
    }

    public Dosen(int dosen_id) {
        this.dosen_id = dosen_id;
    }

    public Dosen(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Dosen(int dosen_id, String name, String address) {
        this.dosen_id = dosen_id;
        this.name = name;
        this.address = address;
    }
}
