package com.Productos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.ProductosDTO;
import com.Productos.service.ProductoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/actualizarProducto/{idProducto}")
public class ActualizarProducto {
    
    @Autowired
    private ProductoService productoService;

    @PutMapping
    public ResponseEntity<?> actualizarProducto(@PathVariable Long idProducto, @RequestBody @Valid ProductosDTO dto){

        productoService.ActualizarProducto(idProducto, dto);

        return ResponseEntity.ok(Map.of("mensaje", "Producto con ID " +idProducto+" actualizado correctamente"));

    }
}
