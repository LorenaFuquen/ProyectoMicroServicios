package com.Productos.controller;

import com.Productos.service.ProductoService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productos/eliminarProducto/{idProducto}")
public class EliminarProducto {

    
    @Autowired
    private ProductoService productoService;

    @DeleteMapping
    public ResponseEntity<?> eliminarProducto(@PathVariable Long idProducto){
        productoService.EliminarProducto(idProducto);

        return ResponseEntity.ok(Map.of("mensaje", "Producto eliminado con ID "+idProducto+" correctamente"));
    }
    
}
