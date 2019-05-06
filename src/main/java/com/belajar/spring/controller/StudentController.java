package com.belajar.spring.controller;

import com.belajar.spring.entity.Student;
import com.belajar.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Student());
        return "/student/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", service.findById(id));
        return "/student/update";
    }

    @PostMapping(value = "/create")
    public String save(Student param) {
        Student data = service.save(param);
        if (data.getStudent_id() == 0) {
            return "redirect:/student?failed";
        } else {
            return "redirect:/student?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Student param) {
        Student data = service.update(param);
        if (data.getStudent_id() == 0) {
            return "redirect:/student?ufailed";
        } else {
            return "redirect:/student?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Student param) {
        int data = service.delete(param);
        if (data == 0) {
            return "redirect:/student?dfailed";
        } else {
            return "redirect:/student?dsuccess";
        }
    }

    @GetMapping(path = "")
        public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                @RequestParam(value = "filter", required = false) String param1) {
            if (param == null && param1 == null) {
                model.addAttribute("dataSets", service.find());
            } else {
                Student student = new Student();
                student.setName(param);
                model.addAttribute("dataSets", service.findByName(student));
            }
        return "/student/list";
    }
}
