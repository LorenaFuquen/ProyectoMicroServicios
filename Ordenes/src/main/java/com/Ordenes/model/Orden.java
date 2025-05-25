package com.Ordenes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "Orden")
public class Orden{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrden")
    private Long idOrden;

    @CreationTimestamp
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "idMedioPago")
    private MedioPago medioPago;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ElementCollection
    @CollectionTable(name = "OrdenProductos", joinColumns = @JoinColumn (name = "idOrden"))
    @Column(name = "idProducto")
    private List<Long> idsPrductos;

    @Column(name = "fechaEntrega")
    private LocalDate fechaEntrega;

    @Column(name = "valorTotal")
    private Double valorTotal;

    public Orden(){

    }

    public Long getIdOrden(){
        return idOrden;
    }

    public void setIdOrden(Long idOrden ){
        this.idOrden = idOrden;
    }

    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public MedioPago getMedioPago(){
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago){
        this.medioPago = medioPago;
    }

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
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

    public Double getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal){
        this.valorTotal= valorTotal;
    }
}
