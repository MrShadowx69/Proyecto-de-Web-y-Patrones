/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author secog
 */
@Controller
@RequestMapping("/inicio sesion")
public class InicioSesionController {
    
  @GetMapping("/listado")
    public String listado(Model model) {
        return "/inicio sesion/listado";
    }
    
}
