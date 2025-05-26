package com.Ordenes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.services.OrdenService;



@RestController
@RequestMapping("ordenes/eliminarOrden/{idOrden}")
public class EliminarOrdenes {

    @Autowired
    private OrdenService ordenService;

    @DeleteMapping
    public ResponseEntity<?> eliminarOrdenes(@PathVariable Long idOrden){
        ordenService.EliminarOrden(idOrden);

        return ResponseEntity.ok(Map.of("mensaje", "Orden eliminada con ID "+idOrden+" correctamente"));
    }
    
}
