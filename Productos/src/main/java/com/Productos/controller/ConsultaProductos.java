package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.Productos;
import com.Productos.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/buscarproductos")

public class ConsultaProductos {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Productos> listaProductos(){
        return productoService.buscarTodos();
    }
        

}
