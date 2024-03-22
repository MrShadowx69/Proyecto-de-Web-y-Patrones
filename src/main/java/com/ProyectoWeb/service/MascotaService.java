/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Mascota;
import java.util.List;

/**
 *
 * @author secog
 */
public interface MascotaService {
    
    public List<Mascota> getMascotas(boolean activos);
    
    public Mascota getMascota(Mascota mascota);
  
    public void save(Mascota mascota);
    

    public void delete(Mascota mascota);
    
    List<Mascota> buscarPorNombre(String nombre);

}
