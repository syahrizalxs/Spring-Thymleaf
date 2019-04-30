/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.controller;

import com.belajar.spring.entity.Jurusan;
import com.belajar.spring.service.JurusanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Desi Widyawati
 */
@RestController
public class JurusanController {
    @Autowired
    private JurusanService service;

    @GetMapping(value = "/jurusan")
    public List<Jurusan> jurusan() {
        return service.find();
    }

    @GetMapping(value = "/jurusan/{id}")
    public Jurusan findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/jurusan")
    public String save(@RequestBody Jurusan student) {
        Jurusan data = service.save(student);
            
        if ( data.getJurusan_id() == null) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/jurusan")
    public String update(@RequestBody Jurusan student) {
        Jurusan data = service.update(student);
        
        if (data.getJurusan_id() == null) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/jurusan/{id}")
    public String delete(@PathVariable("id") String jurusan_id) {
        int data = service.delete(new Jurusan(jurusan_id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
