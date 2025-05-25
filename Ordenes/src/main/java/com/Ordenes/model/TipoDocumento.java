package com.Ordenes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoDocumento")
public class TipoDocumento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    private String tipoDocumento;

    public TipoDocumento(){

    }

    public TipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

    public Long getIdTipoDocumento(){
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento){
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getTipoDocumento(){
        return tipoDocumento;
    }

    public void  setTipoDocumento(String tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

}
