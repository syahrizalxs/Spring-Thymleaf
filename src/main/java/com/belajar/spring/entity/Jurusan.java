/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Desi Widyawati
 */

@Getter
@Setter
public class Jurusan implements Serializable {
    
    private String jurusan_id;
    private String namaJurusan;
    private String fakultas;
    
    public Jurusan(){
        
    }
    
    public Jurusan(String jurusan_id) {
        this.jurusan_id = jurusan_id;
    }

    public Jurusan(String jurusan_id, String namaJurusan, String fakultas) {
        this.jurusan_id = jurusan_id;
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }

    public Jurusan(String namaJurusan, String fakultas) {
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }
    
    
    
    
}
