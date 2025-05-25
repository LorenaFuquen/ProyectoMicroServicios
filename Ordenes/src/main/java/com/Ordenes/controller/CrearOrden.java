package com.Ordenes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.dto.OrdenDTO;
import com.Ordenes.model.Orden;
import com.Ordenes.services.OrdenService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("ordenes/crearOrden")
public class CrearOrden {
    
    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<Orden> crearNuevaOrden(@RequestBody OrdenDTO ordenDTO){
        Orden orden = ordenService.CrearOrden(ordenDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orden);

    }

}
