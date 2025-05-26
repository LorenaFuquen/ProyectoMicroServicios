package com.Ordenes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonasDTO {

    private Long idPersona;

    @NotNull(message = "El ID de la categoria es obligatoria")
    private Long idTipoDocumento;

    @NotBlank(message = "El nombre de la persona es obligatorio")
    private String numeroDocumento;
    
    @NotBlank(message = "El nombre de la persona es obligatorio")
    private String nombrePersona;
    private String correo;
    private String telefono;
    private String direccion;

    public PersonasDTO(){

    }   
    
    public Long getIdPersona(){
        return idPersona;
    }

    public void setIdPersona(Long idPersona){
        this.idPersona= idPersona;
    }

    public Long getIdTipoDocumento(){
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento){
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumeroDocumento(){
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento){
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombrePersona(){
        return nombrePersona;
    }

    public void setNombrePersona(String nommbrePersona){
        this.nombrePersona = nommbrePersona;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}
