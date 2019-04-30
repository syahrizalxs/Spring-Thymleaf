package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */
@Getter
@Setter
public class Student implements Serializable {

    private int student_id;

    private String name;

    private String address;
    
    private String namaJurusan;
    
    private String fakultas;


    public Student() {
    }

    public Student(int student_id) {
        this.student_id = student_id;
    }

    public Student(String name, String address,String namaJurusan,String fakultas) {
        this.name = name;
        this.address = address;    
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }

    public Student(int student_id, String name, String address,String namaJurusan,String fakultas) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }
}
