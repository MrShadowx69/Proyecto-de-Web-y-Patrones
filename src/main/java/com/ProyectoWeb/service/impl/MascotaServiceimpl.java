/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.MascotaDao;
import com.ProyectoWeb.domain.Mascota;
import com.ProyectoWeb.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author secog
 */
@Service
public class MascotaServiceimpl implements MascotaService{
    @Autowired
    private MascotaDao mascotaDao;

    
    @Override
    @Transactional(readOnly = true)
    public List<Mascota> getMascotas(boolean activos) {
       var lista = mascotaDao.findAll();
        
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Mascota getMascota(Mascota mascota) {
        return mascotaDao.findById(mascota.getIdMascota()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Mascota mascota) {
        mascotaDao.save(mascota);
    }
    @Override
    @Transactional
    public void delete(Mascota mascota) {
        mascotaDao.delete(mascota);
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Mascota> buscarPorNombre(String nombre) {
        return mascotaDao.findByNombreContaining(nombre);
    }

    

    
}
