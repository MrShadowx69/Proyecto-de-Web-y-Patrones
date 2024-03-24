/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Mascota;
import com.ProyectoWeb.service.ClienteService;
import com.ProyectoWeb.service.MascotaService;

import com.ProyectoWeb.service.impl.FireBaseStorageServiceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mateorincongonzalez
 */
@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listado")
    public String listado(Model model) {

        List<Mascota> lista = mascotaService.getMascotas(false);
        model.addAttribute("mascota", lista);
        model.addAttribute("mascotas", mascotaService.getMascotas(true));
        model.addAttribute("clientes", clienteService.getClientes(true));

        return "/mascotas/listado";
    }

    @GetMapping("/nuevo")
    public String mascotaNuevo(Mascota mascota) {
        return "/mascotas/modifica";
    }

    @Autowired
    private FireBaseStorageServiceimpl firebaseStorageService;

    @PostMapping("/guardar")
    public String mascotaGuardar(Mascota mascota,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            mascotaService.save(mascota);
            mascota.setImagenMascota(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "mascotas",
                            mascota.getIdMascota()));
        }
        mascotaService.save(mascota);
        return "redirect:/mascotas/listado";
    }

    @GetMapping("/eliminar/{idMascota}")
    public String mascotaEliminar(Mascota mascota) {
        mascotaService.delete(mascota);
        return "redirect:/mascotas/listado";
    }

    @GetMapping("/modificar/{idMascota}")
    public String mascotaModificar(Mascota mascota, Model model) {
        mascota = mascotaService.getMascota(mascota);
        model.addAttribute("mascotas", mascota);
        model.addAttribute("clientes", clienteService.getClientes(true));
        return "/mascotas/modifica";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var mascotas = mascotaService.getMascotas(false);
        model.addAttribute("mascotas", mascotas);
        return "/pruebas/listado2";
    }

    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam(value = "nombre") String nombre, Model model) {
        List<Mascota> mascotas = mascotaService.buscarPorNombre(nombre);
        model.addAttribute("mascotas", mascotas);
        return "/mascotas/listado";
    }

}
