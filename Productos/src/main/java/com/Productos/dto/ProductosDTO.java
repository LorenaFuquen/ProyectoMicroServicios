package com.Productos.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductosDTO{

    private Long idProducto;
    
    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombreProducto;

    private String descripcion;
    
    private String color;
    
    @NotNull(message = "El precio del producto es obligatorio")
    @Min(value = 0, message = "El valor del precio no puede ser negativo")
    private Double precio;

    @NotNull(message = "El ID de la categoria es obligatoria")
    private Long idCategoria;

    private String nombreCategoria;

    @NotNull(message = "El ID de la marca es obligatoria")
    private Long idMarca;

    private String nombreMarca;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long idEstado;

    private String nombreEstado;

    @NotNull(message = "El ID del tipo de producto es obligatoria")
    private Long idTipo;

    private String nombreTipo;

    private String imageBase64;

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

    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }

    public Double getPrecio(){
        return precio;
    }
    
    public void setPrecio(Double precio){
        this.precio = precio;
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
    
    public String getImageBase64(){
        return imageBase64;
    }

    public void setImageBase64(String imageBase64){
        this.imageBase64 = imageBase64;
    }

}