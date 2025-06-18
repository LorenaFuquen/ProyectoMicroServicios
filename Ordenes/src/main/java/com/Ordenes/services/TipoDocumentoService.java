package com.Ordenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ordenes.model.TipoDocumento;
import com.Ordenes.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {
    
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public List<TipoDocumento> BuscarTipos(){
        return tipoDocumentoRepository.findAll();

    }
}
