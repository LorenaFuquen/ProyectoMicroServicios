package com.Productos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoProducto")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    private String nombreTipo;

    public TipoProducto(){

    }

    public TipoProducto(String nombreTipo){
        this.nombreTipo = nombreTipo;
    }
    
    public Long getIdTipo(){
        return idTipo;
    }

    public void setIdTipo(Long idTipo){
        this.idTipo = idTipo;
    }

    public String getNombreTipo(){
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo){
        this.nombreTipo = nombreTipo;
    }
}
