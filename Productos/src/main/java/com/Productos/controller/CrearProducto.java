package com.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.ProductosDTO;
import com.Productos.model.Productos;
import com.Productos.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("productos/crearProducto")
public class CrearProducto {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Productos> crearProducto(@RequestBody @Valid ProductosDTO dto){
        Productos nuevoProducto = productoService.crearProducto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
}
