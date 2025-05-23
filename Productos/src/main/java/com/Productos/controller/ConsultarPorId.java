package com.Productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.dto.MensajeError;
import com.Productos.model.Productos;
import com.Productos.service.ProductoService;

@RestController
@RequestMapping("api/buscarporid/{idProducto}")
public class ConsultarPorId {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public ResponseEntity<?> buscarPorId(@PathVariable Long idProducto){

        Productos productos = productoService.buscarPorID(idProducto);

        if(productos != null) {
            return ResponseEntity.ok(productos);
        } else{
            String mensaje = "Producto con ID " + idProducto + " no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new MensajeError(mensaje));
        }
        
    }
        

}

    

