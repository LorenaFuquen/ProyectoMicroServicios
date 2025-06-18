package com.Ordenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.model.MedioPago;
import com.Ordenes.services.MedioPagoService;

@RestController
@RequestMapping("ordenes/buscarMedioPago")
public class ConsultarMedioPago {
    
    @Autowired
    private MedioPagoService medioPagoService;

    @GetMapping
    public ResponseEntity<List<MedioPago>> buscarMediosPago(){
        List<MedioPago> mediosPago = medioPagoService.buscarMedioPago();
        return ResponseEntity.ok(mediosPago);
    }
}
