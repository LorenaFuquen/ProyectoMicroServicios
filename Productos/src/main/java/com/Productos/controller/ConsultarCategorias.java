package com.Productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.model.Categoria;
import com.Productos.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("productos/buscarCategorias")
public class ConsultarCategorias {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarCategorias(){
        List<Categoria> categorias = categoriaService.buscarCategorias();
        return ResponseEntity.ok(categorias);
    }
}
