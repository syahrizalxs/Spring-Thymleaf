package com.belajar.spring.controller;

import com.belajar.spring.entity.Jurusan;
import com.belajar.spring.entity.Jurusan;
import com.belajar.spring.service.DosenService;
import com.belajar.spring.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Desi Widyawati
 */
@Controller
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService service;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Jurusan());
        return "/jurusan/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", service.findById(id));
        return "/jurusan/update";
    }

    @PostMapping(value = "/create")
    public String save(Jurusan param) {
        Jurusan data = service.save(param);
        if (data.getId() == 0) {
            return "redirect:/jurusan?failed";
        } else {
            return "redirect:/jurusan?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Jurusan param) {
        Jurusan data = service.update(param);
        if (data.getId() == 0) {
            return "redirect:/jurusan?ufailed";
        } else {
            return "redirect:/jurusan?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Jurusan param) {
        int data = service.delete(param);
        if (data == 0) {
            return "redirect:/jurusan?dfailed";
        } else {
            return "redirect:/jurusan?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", service.find());
        } else {
            Jurusan user = new Jurusan();
            user.setNamaJurusan(param);
            model.addAttribute("dataSets", service.findByName(user));
        }
        return "/jurusan/list";
    }

}
