package com.Ordenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.model.Orden;
import com.Ordenes.services.OrdenService;
import com.Ordenes.util.MensajeError;


@RestController
@RequestMapping("ordenes/buscarOrdenes")

public class ConsultarOrdenes {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ResponseEntity<?> listaOrdenes(){

        List<Orden> orden = ordenService.BuscarTodas();

        if(orden.isEmpty()){
            String mensaje = "No existen ordenes creados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        
        return ResponseEntity.ok(orden);
    }

}