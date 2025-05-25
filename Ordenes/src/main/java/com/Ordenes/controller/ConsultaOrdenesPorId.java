package com.Ordenes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.model.Orden;
import com.Ordenes.services.OrdenService;
import com.Ordenes.util.MensajeError;

@RestController
@RequestMapping("ordenes/buscarOrdenPorId/{idOrden}")
public class ConsultaOrdenesPorId {
    
    @Autowired
    private OrdenService ordenService;


    @GetMapping
    public ResponseEntity<?> buscarOrdenPorId(@PathVariable Long idOrden){

        Orden orden = ordenService.buscarPorId(idOrden);

        if(orden != null) {
            return ResponseEntity.ok(orden);
        } else{
            String mensaje = "Orden No. " + idOrden + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        
    }
}
