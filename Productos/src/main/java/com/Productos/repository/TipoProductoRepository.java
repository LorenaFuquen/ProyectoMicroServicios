package com.Productos.repository;

import com.Productos.model.TipoProducto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    
}
