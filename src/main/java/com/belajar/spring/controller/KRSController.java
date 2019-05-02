package com.belajar.spring.controller;

import com.belajar.spring.entity.KRS;
import com.belajar.spring.entity.KRS;
import com.belajar.spring.service.KRSService;
import com.belajar.spring.service.KRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KRSController {

    @Autowired
    private KRSService service;

    
    @GetMapping(value = "/krs")
    public List<KRS> krs() {
        return service.find();
    }

    @GetMapping(value = "/krs/{id}")
    public KRS findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
    

    @PostMapping(value = "/krs")
    public String save(@RequestBody KRS krs) {
        KRS data = service.save(krs);
        if (data.getStudent_id() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/krs")
    public String update(@RequestBody KRS krs) {
        KRS data = service.update(krs);
        if (data.getStudent_id() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/krs/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new KRS(id.toString()));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
