package com.Productos.repository;

import com.Productos.model.Marca;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
}