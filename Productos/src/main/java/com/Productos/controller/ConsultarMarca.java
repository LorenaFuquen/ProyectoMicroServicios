package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.Marca;
import com.Productos.service.MarcaService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("productos/buscarMarcas")
public class ConsultarMarca {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> buscarMarcas(){
        List<Marca> marca = marcaService.buscarMarca();
        return ResponseEntity.ok(marca);
    }
    
}
