package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KRS {

    private String NoKRS;
    private int student_id;
    private String name;
    private String namaMataKuliah;
    private String jumlahSKS;

    public KRS(String NoKRS, int student_id, String name, String namaMataKuliah, String jumlahSKS) {
        this.NoKRS = NoKRS;
        this.student_id = student_id;
        this.name = name;
        this.namaMataKuliah = namaMataKuliah;
        this.jumlahSKS = jumlahSKS;
    }

    public KRS(int student_id, String name, String namaMataKuliah, String jumlahSKS) {
        this.student_id = student_id;
        this.name = name;
        this.namaMataKuliah = namaMataKuliah;
        this.jumlahSKS = jumlahSKS;
    }


    public KRS() {
    }

    public KRS(String NoKRS) {
        this.NoKRS = NoKRS;
    }

   
}
