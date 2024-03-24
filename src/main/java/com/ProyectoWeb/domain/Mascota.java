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
@Table(name="mascota")

public class Mascota implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Mascota")
    private Long idMascota; //Esto equivale en la DB como id_categoria, ya que en java se usa camelCase
    private String nombre;
    private String especie;
    private String raza;
    private String edad;
    private Long idCliente;
    private String imagenMascota;
 
    
    public Mascota(){
    
    }

    public Mascota( String nombre, String especie, String raza, String edad, Long idCliente, String imagenMascota) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.idCliente = idCliente;
        this.imagenMascota = imagenMascota;
        
    }

    

    

    

    
}
