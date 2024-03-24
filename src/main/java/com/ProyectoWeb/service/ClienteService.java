/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Cliente;
import java.util.List;




/**
 *
 * @author secog
 */
public interface ClienteService {

    public List<Cliente> getClientes(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Cliente getCliente(Cliente cliente);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Cliente cliente);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Cliente cliente);

    public List<Cliente> buscarPorCorreo(String email);
}
