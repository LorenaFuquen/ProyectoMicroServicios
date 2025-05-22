package com.Productos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estado")
public class Estado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    private String nombreEstado;

    public Estado(){
    }

    public Estado(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }

    public Long getIdEstado(){
        return idEstado;
    }

    public void setIdEstado(Long idEstado){
        this.idEstado= idEstado;
    }

    public String getNombreEstado(){
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado){
        this.nombreEstado= nombreEstado;
    }

}


