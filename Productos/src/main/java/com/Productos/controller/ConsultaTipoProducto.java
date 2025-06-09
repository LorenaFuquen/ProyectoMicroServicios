package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.TipoProducto;
import com.Productos.service.TipoProductoService;

@RestController
@RequestMapping("productos/buscarTipoProducto")
public class ConsultaTipoProducto {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<List<TipoProducto>> buscarTipoProducto(){
        List<TipoProducto> tipoProductos = tipoProductoService.buscarTipoProducto();
        return ResponseEntity.ok(tipoProductos);
    }
    
}
