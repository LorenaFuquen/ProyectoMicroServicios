package com.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Productos.model.Estado;

import com.Productos.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    
    public List<Estado> buscarEstado() {
        return estadoRepository.findAll();
    }

}
