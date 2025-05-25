package com.Ordenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.model.Orden;
import com.Ordenes.services.OrdenService;
import com.Ordenes.util.MensajeError;

@RestController
@RequestMapping("ordenes/buscarPorNumeroDocumento")
public class ConsultaPorNumDocumento {
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ResponseEntity<?> buscarPorNumDocumento(@RequestParam String numeroDocumento){

        List<Orden> orden = ordenService.buscarPorNumeroDocumento(numeroDocumento);

        if(orden.isEmpty()) {
        
            String mensaje = "No existen orden asociadas al nunmero de documento " + numeroDocumento ;
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        return ResponseEntity.ok(orden);

        
    } 

}
