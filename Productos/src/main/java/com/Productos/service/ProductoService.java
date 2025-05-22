package com.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Productos.model.Productos;
import com.Productos.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    //Busquedas

    //Buscar todos los productos
    public List<Productos> buscarTodos(){
        return productoRepository.findAll();
    }

    //Buscar producto por ID
    public Productos buscarPorID(Long idProducto){
        return productoRepository.findById(idProducto).orElse(null);
    }

    //Buscar producto por nombre
    public List<Productos> buscarPorNombre(String nombreProducto){
        return productoRepository.buscarPorNombre("%" + nombreProducto + "%");
    }

    //Insertar producto
    public Productos crearProducto(Productos productos){
        return productoRepository.save(productos);
    }

}
