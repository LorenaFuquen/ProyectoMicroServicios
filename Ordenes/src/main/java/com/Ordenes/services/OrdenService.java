package com.Ordenes.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ordenes.dto.OrdenDTO;
import com.Ordenes.dto.ProductosDTO;
import com.Ordenes.model.MedioPago;
import com.Ordenes.model.Orden;
import com.Ordenes.model.Persona;
import com.Ordenes.model.TipoDocumento;
import com.Ordenes.repository.*;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;
    
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    // Llama al microservicio de productos
    @Autowired
    private ProductoService productoService;
    
    public Orden CrearOrden(OrdenDTO ordenDTO){

        //Informacion obtenida desde el servicio de productos
        List<Long> idsConsultados = ordenDTO.getIdsProductos();
        List<ProductosDTO> productos = productoService.obtenerIdsProductos(ordenDTO.getIdsProductos());

        //Valida que el producto ingresado exista
        if(productos.size() != idsConsultados.size()){
            throw new RuntimeException("Uno o más de los productos no existen o estan inactivos");
        }
        
        //Valida disponiblidad del producto
        for(ProductosDTO producto : productos ){

            if (producto.getIdEstado() == 2){
                throw new RuntimeException("El producto " +producto.getNombreProducto()+ "esta agotado");
            }
        }
        
        //Valida que la persona exista 
        
        Persona persona;

        Optional<Persona> existePersona = personaRepository.findByNumeroDocumento(ordenDTO.getPersonas().getNumeroDocumento());

        if(existePersona .isPresent()){
            persona = existePersona.get();
        } else {
            //Crear nueva persona asociada a la orden
            persona = new Persona();

            TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(ordenDTO.getPersonas().getIdTipoDocumento())
            .orElseThrow(() -> new RuntimeException("Tipo de documento con ID "+ordenDTO.getPersonas().getIdTipoDocumento()+ " no encontrado"));
            
            persona.setTipoDocumento(tipoDocumento);
            persona.setNumeroDocumento(ordenDTO.getPersonas().getNumeroDocumento());
            persona.setNombrePersona(ordenDTO.getPersonas().getNombrePersona());
            persona.setCorreo(ordenDTO.getPersonas().getCorreo());
            persona.setTelefono(ordenDTO.getPersonas().getTelefono());
            persona.setDireccion(ordenDTO.getPersonas().getDireccion());

            personaRepository.save(persona);
        }

        // Suma los precios de los productos
        double valorTotal = productos.stream().mapToDouble(ProductosDTO::getPrecio).sum();

        //Crear nueva orden
        Orden orden = new Orden();

        orden.setFechaCreacion(LocalDateTime.now());

        MedioPago medioPago = medioPagoRepository.findById(ordenDTO.getIdMedioPago())
        .orElseThrow(() -> new RuntimeException("El medio de pago registrado no existe"));

        orden.setMedioPago(medioPago);
        orden.setPersona(persona);
        orden.setIdsProductos(ordenDTO.getIdsProductos());
        orden.setFechaEntrega(ordenDTO.getFechaEntrega());
        orden.setValorTotal(valorTotal);
        
        return ordenRepository.save(orden);

    }

    //Buscar todas las ordenes
    public List<Orden> BuscarTodas(){
        return ordenRepository.findAll();
    }

    //Buscar ordenes por ID
    public Orden buscarPorId(Long idOrden){
        return ordenRepository.findById(idOrden).orElse(null);
    }

    //Buscar ordenes por numero de documento de la persona
    public List<Orden> buscarPorNumeroDocumento(String numeroDocumento){
        return ordenRepository.buscarPorNumeroDocumento(numeroDocumento);
    }

    //Actualizar ordenes
    public Orden ActualizarOrdenes(OrdenDTO ordenDTO){

        Orden orden = ordenRepository.findById(ordenDTO.getIdOrden())
        .orElseThrow(() -> new RuntimeException("La orden No. " +ordenDTO.getIdOrden()+ " no existe"));

        Persona persona;
        Optional<Persona> existePersona = personaRepository.findByNumeroDocumento(ordenDTO.getPersonas().getNumeroDocumento());
        if(existePersona.isPresent()){
            persona = existePersona.get();
        }else{
            persona = new Persona();
            TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(ordenDTO.getPersonas().getIdTipoDocumento())
            .orElseThrow(()-> new RuntimeException("Tipo de documento con ID "+ordenDTO.getPersonas().getIdTipoDocumento()+" no existe"));

            persona.setTipoDocumento(tipoDocumento);
            persona.setNumeroDocumento(ordenDTO.getPersonas().getNumeroDocumento());
            persona.setNombrePersona(ordenDTO.getPersonas().getNombrePersona());
            persona.setCorreo(ordenDTO.getPersonas().getCorreo());
            persona.setTelefono(ordenDTO.getPersonas().getTelefono());
            persona.setDireccion(ordenDTO.getPersonas().getDireccion());

            personaRepository.save(persona);

        }
        orden.setPersona(persona);

        if (ordenDTO.getIdMedioPago() != null) {
            MedioPago medioPago = medioPagoRepository.findById(ordenDTO.getIdMedioPago())
                .orElseThrow(() -> new RuntimeException("Medio de pago con id " + ordenDTO.getIdMedioPago() + " no encontrado"));
            orden.setMedioPago(medioPago);
        }

        if (ordenDTO.getFechaEntrega() != null) {
            orden.setFechaEntrega(ordenDTO.getFechaEntrega());
        }

        //Añadir o reemplazar productos 
       if(ordenDTO.getIdsProductos() != null && !ordenDTO.getIdsProductos().isEmpty()){

        List<Long> productosFinales;

        if(ordenDTO.isReemplazarProductos()){
            //Reemplaza productos en la orden
            productosFinales = ordenDTO.getIdsProductos();
        }else{

            List<Long> productosActuales = ordenDTO.getIdsProductos();
            if(productosActuales == null){
                productosActuales = new ArrayList<>();
            }
            Set<Long> productosAñadidos = new HashSet<>(productosActuales);
            productosAñadidos.addAll(ordenDTO.getIdsProductos());
            productosFinales = new ArrayList<>(productosAñadidos);
            }
        
        List<ProductosDTO> productosValidados = productoService.obtenerIdsProductos(productosFinales);

        if(productosValidados.size() != productosFinales.size()){
            throw new RuntimeException("Uno o más productos no existen o están inactivos");
        }

        for (ProductosDTO productos : productosValidados){
            if(productos.getIdEstado()== 2){
                throw new RuntimeException("El producto " + productos.getNombreProducto() + " está agotado");
            }
        }

        orden.setIdsProductos(productosFinales);

        //Recalcula el valor total
        double valorTotal = productosValidados.stream()
            .mapToDouble(ProductosDTO::getPrecio)
            .sum();

        orden.setValorTotal(valorTotal);

       }

    return ordenRepository.save(orden);

    }

    //Eliminar ordenes
    public void EliminarOrden (Long idOrden){
        Orden orden = ordenRepository.findById(idOrden).
        orElseThrow(() -> new RuntimeException("Producto con ID " + idOrden + " no existe" ));

        ordenRepository.delete(orden);
    }
}
