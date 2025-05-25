package com.Ordenes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Persona")
public class Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @ManyToOne
    @JoinColumn (name = "idTipoDocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "nombrePersona")
    private String nombrePersona;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    public Persona(){

    }

    public Long getIdPersona(){
        return idPersona;
    }

    public void setIdPersona(Long idPersona){
        this.idPersona= idPersona;
    }

    public TipoDocumento getTipoDocumento(){
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento){
        this.tipoDocumento = tipoDocumento;
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