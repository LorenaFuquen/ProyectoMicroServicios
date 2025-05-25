package com.Ordenes.model;

import jakarta.persistence.*;


@Entity
@Table(name = "MedioPago")
public class MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioPago;

    private String nombreMedio;

    public MedioPago(){

    }

    public MedioPago(String nombreMedio){
        this.nombreMedio = nombreMedio;
    }

    public Long getIdMedioPago(){
        return idMedioPago;
    }

    public void setIdMedioPago(Long idMedioPago){
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedio(){
        return nombreMedio;
    }

    public void setNombreMedio(String nombreMedio){
        this.nombreMedio = nombreMedio;
    }

    
}
