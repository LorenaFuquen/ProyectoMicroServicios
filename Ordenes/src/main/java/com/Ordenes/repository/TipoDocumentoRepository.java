package com.Ordenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ordenes.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

}