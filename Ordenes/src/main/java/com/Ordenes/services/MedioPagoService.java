package com.Ordenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ordenes.repository.MedioPagoRepository;
import com.Ordenes.model.MedioPago;


@Service
public class MedioPagoService {

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    public List<MedioPago> buscarMedioPago(){
        return medioPagoRepository.findAll();
    }
    
}
