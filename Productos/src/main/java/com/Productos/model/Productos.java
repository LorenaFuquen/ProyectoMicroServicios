package com.Productos.model;



import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "color")
    private String color;

    @Column(name = "precio")
    private Double precio;

    // Etiqueta para marcar la relación de uno muchos para las llaves foraneas de las tablas
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoProducto tipoProducto;

    @Lob
    @Column(name = "imageBase64", columnDefinition = "LONGTEXT")
    private String imageBase64;

    public Productos() {
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

    public Categoria getCategoria(){
        return categoria;
    }
    
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Marca getMarca(){
        return marca;
    }
    
    public void setMarca(Marca marca){
        this.marca = marca;
    }

    public Estado getEstado(){
        return estado;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public TipoProducto getTipoProducto(){
        return tipoProducto;
    }
    
    public void setTipoProducto(TipoProducto tipoProducto){
        this.tipoProducto = tipoProducto;
    }

    public String getImageBase64(){
        return imageBase64;
    }

    public void setImageBase64(String imageBase64){
        this.imageBase64 = imageBase64;
    }
    
}
