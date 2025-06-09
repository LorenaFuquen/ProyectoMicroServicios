package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.Estado;
import com.Productos.service.EstadoService;

@RestController
@RequestMapping("productos/buscarEstado")
public class ConsultarEstado {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> buscarEstado(){
        List<Estado> estados = estadoService.buscarEstado();
        return ResponseEntity.ok(estados);
    }
    
}
