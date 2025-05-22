package com.Productos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Marca") //Mapea la tabla de la base de datos 
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;

    private String nombreMarca;

    public Marca(){    
    }

    public Marca(String nombreMarca){
        this.nombreMarca = nombreMarca;
    }

    public Long getIdMarca(){
        return idMarca;
    }

    public void setIdMarca(Long idMarca){
        this.idMarca = idMarca;
    }

    public String getNombreMarca(){
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca){
        this.nombreMarca = nombreMarca;
    }
} 

