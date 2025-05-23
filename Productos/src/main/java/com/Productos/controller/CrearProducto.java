package com.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.Productos;
import com.Productos.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/crearProducto")
public class CrearProducto {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Productos nuevoProducto(@RequestBody Productos productos){
        return productoService.crearProducto(productos);
    }
}
