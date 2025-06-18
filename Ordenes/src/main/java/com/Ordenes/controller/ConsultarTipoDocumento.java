package com.Ordenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.model.TipoDocumento;
import com.Ordenes.services.TipoDocumentoService;

@RestController
@RequestMapping("ordenes/buscarTipoDocumento")
public class ConsultarTipoDocumento {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

     @GetMapping
    public ResponseEntity<List<TipoDocumento>> buscarTipoDoc(){
        List<TipoDocumento> tipoDocumento = tipoDocumentoService.BuscarTipos();
        return ResponseEntity.ok(tipoDocumento);
    }
    
}
