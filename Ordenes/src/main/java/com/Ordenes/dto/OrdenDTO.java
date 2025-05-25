package com.Ordenes.dto;

import java.time.LocalDate;
import java.util.List;


public class OrdenDTO {

    private Long idOrden;
    private Long idMedioPago;
    private PersonasDTO personas;
    private List<Long> idsPrductos;
    private LocalDate fechaEntrega;

    public OrdenDTO(){

    }

    public Long getIdOrden(){
        return idOrden;
    }

    public void setIdOrden(Long idOrden ){
        this.idOrden = idOrden;
    }

    public Long getIdMedioPago(){
        return idMedioPago;
    }

    public void setIdMedioPago(Long idMedioPago){
        this.idMedioPago = idMedioPago;
    }

    public PersonasDTO getPersonas(){
        return personas;
    }

    public void setPersonas(PersonasDTO personas){
        this.personas = personas;
    }

    public List<Long> getIdsProductos(){
        return idsPrductos;
    }

    public void setIdsProductos(List<Long> idsProductos){
        this.idsPrductos = idsProductos;
    }

    public LocalDate getFechaEntrega(){
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega){
        this.fechaEntrega = fechaEntrega;
    }
    
}
