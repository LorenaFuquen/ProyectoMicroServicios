package com.Productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Productos.dto.ProductosDTO;
import com.Productos.model.Categoria;
import com.Productos.model.Estado;
import com.Productos.model.Marca;
import com.Productos.model.Productos;
import com.Productos.model.TipoProducto;
import com.Productos.repository.CategoriaRepository;
import com.Productos.repository.MarcaRepository;
import com.Productos.repository.EstadoRepository;
import com.Productos.repository.ProductoRepository;
import com.Productos.repository.TipoProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

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
    public Productos crearProducto(ProductosDTO dto){

        //Valida que exista la categoria registrada
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
        .orElseThrow(() -> new RuntimeException("Categoría con ID: " + dto.getIdCategoria() + " no existe"));

        //Valida que exista la marca registrada
        Marca marca = marcaRepository.findById(dto.getIdMarca())
        .orElseThrow(() -> new RuntimeException("Marca con ID: " + dto.getIdMarca() + " no existe"));

        //Valida que exista el estado registrada
        Estado estado = estadoRepository.findById(dto.getIdEstado())
        .orElseThrow(() -> new RuntimeException("Estado con ID: " + dto.getIdMarca() + " no existe"));

        TipoProducto tipoProducto = tipoProductoRepository.findById(dto.getIdTipo())
        .orElseThrow(() -> new RuntimeException("Tipo de producto con ID: " + dto.getIdTipo() + " no existe"));

        Productos productos = new Productos();

        productos.setNombreProducto(dto.getNombreProducto());
        productos.setDescripcion(dto.getDescripcion());
        productos.setColor(dto.getColor());
        productos.setPrecio(dto.getPrecio());
        productos.setCategoria(categoria);
        productos.setMarca(marca);
        productos.setEstado(estado);
        productos.setTipoProducto(tipoProducto);

        return productoRepository.save(productos);
    }

    //Actualizar producto
    public Productos ActualizarProducto(Long idProducto, ProductosDTO dto ){
        Productos productos = productoRepository.findById(idProducto).
        orElseThrow(() -> new RuntimeException("Producto con ID " + idProducto + " no existe" ));

         //Valida que exista la categoria registrada
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
        .orElseThrow(() -> new RuntimeException("Categoría con ID: " + dto.getIdCategoria() + " no existe"));

        //Valida que exista la marca registrada
        Marca marca = marcaRepository.findById(dto.getIdMarca())
        .orElseThrow(() -> new RuntimeException("Marca con ID: " + dto.getIdMarca() + " no existe"));

        //Valida que exista el estado registrada
        Estado estado = estadoRepository.findById(dto.getIdEstado())
        .orElseThrow(() -> new RuntimeException("Estado con ID: " + dto.getIdMarca() + " no existe"));

        TipoProducto tipoProducto = tipoProductoRepository.findById(dto.getIdTipo())
        .orElseThrow(() -> new RuntimeException("Tipo de producto con ID: " + dto.getIdTipo() + " no existe"));

        productos.setNombreProducto(dto.getNombreProducto());
        productos.setDescripcion(dto.getDescripcion());
        productos.setColor(dto.getColor());
        productos.setPrecio(dto.getPrecio());
        productos.setCategoria(categoria);
        productos.setMarca(marca);
        productos.setEstado(estado);
        productos.setTipoProducto(tipoProducto);

        return productoRepository.save(productos); 

    }

    //Eliminar producto
    public void EliminarProducto (Long idProducto){
        Productos productos = productoRepository.findById(idProducto).
        orElseThrow(() -> new RuntimeException("Producto con ID " + idProducto + " no existe" ));

        productoRepository.delete(productos);
    }

}
