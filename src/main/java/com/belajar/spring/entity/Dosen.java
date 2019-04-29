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
 * @author Desi Widyawati
 */
@Getter
@Setter
public class Dosen implements Serializable {
    private int id;

    private String name;

    private String address;

    public Dosen() {
    }

    public Dosen(int id) {
        this.id = id;
    }

    public Dosen(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Dosen(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
