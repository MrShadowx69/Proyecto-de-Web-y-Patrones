/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author secog
 */
public interface MascotaDao extends JpaRepository<Mascota, Long>{
        List<Mascota> findByNombreContaining(String nombre);

    
}
