package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.ProductosDTO;
import com.Productos.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("productos/obtenerIdsProductos")
public class ObtenerIdsProductos {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<List<ProductosDTO>> IdProductos(@RequestBody List<Long> idsProductos){
        List<ProductosDTO> productos = productoService.obtenerIdProductos(idsProductos);
        return ResponseEntity.ok(productos);
    }
}
