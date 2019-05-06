package com.belajar.spring.controller;

import com.belajar.spring.entity.Dosen;
import com.belajar.spring.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Desi Widyawati
 */
@Controller
@RequestMapping("/dosen")
public class DosenController {
     @Autowired
    private DosenService service;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Dosen());
        return "/dosen/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", service.findById(id));
        return "/dosen/update";
    }

    @PostMapping(value = "/create")
    public String save(Dosen param) {
        Dosen data = service.save(param);
        if (data.getDosen_id() == 0) {
            return "redirect:/dosen?failed";
        } else {
            return "redirect:/dosen?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Dosen param) {
        Dosen data = service.update(param);
        if (data.getDosen_id() == 0) {
            return "redirect:/dosen?ufailed";
        } else {
            return "redirect:/dosen?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Dosen param) {
        int data = service.delete(param);
        if (data == 0) {
            return "redirect:/dosen?dfailed";
        } else {
            return "redirect:/dosen?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", service.find());
        } else {
            Dosen user = new Dosen();
            user.setName(param);
            model.addAttribute("dataSets", service.findByName(user));
        }
        return "/dosen/list";
    }
     
}
