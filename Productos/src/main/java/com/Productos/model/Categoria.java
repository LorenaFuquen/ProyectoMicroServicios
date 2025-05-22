package com.Productos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombreCategoria;

    public Categoria(){
    }

    public Categoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

    public Long getIdCategoria(){
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria){
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria(){
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

}