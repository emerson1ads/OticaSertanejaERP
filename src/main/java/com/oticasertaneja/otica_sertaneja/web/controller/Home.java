package com.oticasertaneja.otica_sertaneja.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Bem vindo á Otica Sertaneja");
        return "home";
    }
}
