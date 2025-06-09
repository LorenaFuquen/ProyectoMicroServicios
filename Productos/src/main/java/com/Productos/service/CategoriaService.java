package com.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Productos.model.Categoria;
import com.Productos.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    
    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll();
    }
    
}
