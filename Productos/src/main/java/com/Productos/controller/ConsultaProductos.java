package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.*;
import com.Productos.model.Productos;
import com.Productos.service.*;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/buscarProductos")

public class ConsultaProductos {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> listaProductos(){

        List<Productos> productos = productoService.buscarTodos();

        if(productos.isEmpty()){
            String mensaje = "No existen productos creados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        
        return ResponseEntity.ok(productos);
    }
 

}
