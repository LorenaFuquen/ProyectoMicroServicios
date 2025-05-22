package com.Productos.repository;

import com.Productos.model.Productos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Productos, Long> {

@Query("SELECT pr FROM Productos pr WHERE pr.nombreProducto LIKE :nombreProducto")
List<Productos> buscarPorNombre(@Param("nombreProducto") String nombreProducto);


}