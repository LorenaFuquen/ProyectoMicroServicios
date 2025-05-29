package com.Ordenes.client;

import com.Ordenes.dto.ProductosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Productos", url = "http://localhost:8081") 
public interface ProductoClient {

    @PostMapping("productos/obtenerIdsProductos")
    List<ProductosDTO> obtenerIdsProductos(@RequestBody List<Long> idsProductos);
}
