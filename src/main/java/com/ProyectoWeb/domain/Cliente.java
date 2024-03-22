/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cliente")
    private Long idCliente; //Esto equivale en la DB como id_categoria, ya que en java se usa camelCase
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private boolean activo;
    
    
    public Cliente(){
    
    }

    public Cliente(Long idCliente, String nombre, String apellido, String telefono, String email, boolean activo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.activo = activo;
    }

    
    
    
    
}
