package com.belajar.spring.controller;

import com.belajar.spring.entity.Student;
import com.belajar.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/students")
    public List<Student> students() {
        return service.find();
    }

    @GetMapping(value = "/students/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/students")
    public String save(@RequestBody Student student) {
        Student data = service.save(student);
        if (data.getStudent_id() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/students")
    public String update(@RequestBody Student student) {
        Student data = service.update(student);
        if (data.getStudent_id() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/students/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new Student(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
