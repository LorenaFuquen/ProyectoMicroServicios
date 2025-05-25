package com.Ordenes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Ordenes.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

}