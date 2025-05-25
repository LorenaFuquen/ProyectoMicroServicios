package com.Ordenes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ordenes.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query(value = "SELECT * FROM orden o INNER JOIN persona p ON p.idPersona = o.IdPersona WHERE p.numeroDocumento = :numeroDocumento",nativeQuery = true)
    List<Orden> buscarPorNumeroDocumento(@Param("numeroDocumento") String numeroDocumento);
}