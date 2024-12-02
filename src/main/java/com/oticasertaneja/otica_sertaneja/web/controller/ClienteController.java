package com.oticasertaneja.otica_sertaneja.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oticasertaneja.otica_sertaneja.Entity.Cliente.Cliente;
import com.oticasertaneja.otica_sertaneja.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("cliente")
public class ClienteController {
    
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ModelAndView main(@RequestParam(name = "nome", required = false, defaultValue = " ") String nome ) {
        ModelAndView view = new ModelAndView("cliente/view");
        return view;
    }

    //Adicionar
    @GetMapping("/adicionar")
    public String get(@ModelAttribute("cliente") Cliente cliente){
        return "clientes/adicionar";
    }

    @PostMapping("/adicionar")
    public String salvar(@Valid Cliente cliente){
        clienteService.salva(cliente);
        return "redirect:/cliente/";
    }
    
}
