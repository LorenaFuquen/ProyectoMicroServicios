package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.MensajeError;
import com.Productos.model.Productos;
import com.Productos.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("productos/buscarPorNombre")
public class ConsultaPorNombre {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> buscarPorNombre(@RequestParam String nombreProducto){

        List<Productos> productos = productoService.buscarPorNombre(nombreProducto);

        if(productos.isEmpty()) {
        
            String mensaje = "No existen coincidencia con el nombre " + nombreProducto ;
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        return ResponseEntity.ok(productos);

        
    } 

    
}
