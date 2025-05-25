package com.Ordenes.dto;

public class ProductosDTO {

    private Long idProducto;
    private String nombreProducto;
    private Double precio;
    private Long idEstado;
    private String nombreEstado;

    public ProductosDTO(){

    }

    public Long getIdProducto(){
        return idProducto;
    }

    public void setIdProducto(Long idProducto){
        this.idProducto = idProducto;
    }

    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio(){
        return precio;
    }
    
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public Long getIdEstado(){
        return idEstado;
    }

    public void setIdEstado(Long idEstado){
        this.idEstado = idEstado;
    }

    public String getNombreEstado(){
        return nombreEstado;
    }
    
    public void setNombreEstado(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }

}
