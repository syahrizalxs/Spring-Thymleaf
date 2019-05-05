package com.belajar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String home(Model model) {
        return "index";
    }
}
