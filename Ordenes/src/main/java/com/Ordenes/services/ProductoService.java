package com.Ordenes.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Ordenes.dto.ProductosDTO;



@Service
public class ProductoService {

    @Autowired
    private RestTemplate restTemplate;

    private final String URLProductos = "http://localhost:8081/productos/obtenerIdsProductos";

    public List<ProductosDTO> obtenerIdsProductos(List<Long> idsProductos){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<Long>> request = new HttpEntity<>(idsProductos, headers);
        
        ResponseEntity<ProductosDTO[]> response = restTemplate.exchange(
            URLProductos,
            HttpMethod.POST,
            request,
            ProductosDTO[].class
        );

        return Arrays.asList(response.getBody());

    }

}
