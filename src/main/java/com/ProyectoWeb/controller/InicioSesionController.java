/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Cliente;
import com.ProyectoWeb.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author secog
 */
@Controller
@RequestMapping("/clientes")
public class InicioSesionController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/clientes/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(@ModelAttribute("cliente") Cliente cliente) {        
        clienteService.save(cliente);
        return "redirect:/clientes/listado";
    }
    
    @GetMapping("/listado")
    public String clienteListado(Model model) {
        
        
        return "/clientes/listado";
    }
}
