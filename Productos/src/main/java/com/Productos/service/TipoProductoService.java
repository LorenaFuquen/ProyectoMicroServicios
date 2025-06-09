package com.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Productos.model.TipoProducto;
import com.Productos.repository.TipoProductoRepository;

@Service
public class TipoProductoService {
    
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

     public List<TipoProducto> buscarTipoProducto() {
        return tipoProductoRepository.findAll();
    }
}
