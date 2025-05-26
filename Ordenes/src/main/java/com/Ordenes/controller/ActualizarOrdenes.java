package com.Ordenes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ordenes.dto.OrdenDTO;
import com.Ordenes.model.Orden;
import com.Ordenes.services.OrdenService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("ordenes/actualizarOrdenes/{idOrden}")
public class ActualizarOrdenes {
    
    @Autowired
    private OrdenService ordenService;

    @PutMapping
    public ResponseEntity<Orden> actualizarOrden(@PathVariable Long idOrden, @RequestBody OrdenDTO ordenDTO){
        ordenDTO.setIdOrden(idOrden);

        Orden ordenActualizada = ordenService.ActualizarOrdenes(ordenDTO);
        return ResponseEntity.ok(ordenActualizada);
    }
}
